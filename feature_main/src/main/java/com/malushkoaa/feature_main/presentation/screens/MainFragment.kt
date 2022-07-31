package com.malushkoaa.feature_main.presentation.screens

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.malushkoaa.core.App
import com.malushkoaa.core.di.ViewModelFactory
import com.malushkoaa.feature_main.R
import com.malushkoaa.feature_main.databinding.FragmentMainBinding
import com.malushkoaa.feature_main.di.DaggerMainComponent
import com.malushkoaa.feature_main.presentation.adapters.MainScreenCategoriesContentVPAdapter
import com.malushkoaa.feature_main.presentation.viewmodels.MainViewModel
import javax.inject.Inject


class MainFragment : Fragment() {
    
    private lateinit var mainViewModel: MainViewModel
    
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw RuntimeException("FragmentMainBinding is null")
    
    private val component by lazy {
        DaggerMainComponent.builder()
            .coreComponent((requireActivity().application as App).coreComponent)
            .build()
    }
    
    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        binding.icHomeFilter.setOnClickListener {
            openFilterController()
        }
        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        
        bindTabAndVPager()
        initBottomNavBar()
    }
    
    private fun bindTabAndVPager() {
        
        val categoriesList = mainViewModel.categoriesList
        
        binding.mainScreenCategoriesContentViewPager.adapter =
            MainScreenCategoriesContentVPAdapter(categoriesList, this)
        TabLayoutMediator(
            binding.tabSelectCategory,
            binding.mainScreenCategoriesContentViewPager
        ) { tab, position ->
            val view = layoutInflater.inflate(R.layout.item_category, null, false)
            view.findViewById<ImageView>(R.id.tabIV)
                .setImageResource(categoriesList[position].image)
            view.findViewById<TextView>(R.id.tabTV).text = categoriesList[position].name
            tab.apply {
                customView = view
                if (position == 0) {
                    customView?.apply {
                        findViewById<ImageView>(R.id.tabLayoutCircle).setColorFilter(
                            ContextCompat.getColor(
                                requireContext(),
                                com.malushkoaa.core.R.color.primary
                            )
                        )
                        findViewById<TextView>(R.id.tabTV).setTextColor(Color.parseColor("#FF6E4E"))
                        findViewById<ImageView>(R.id.tabIV).setColorFilter(
                            ContextCompat.getColor(
                                requireContext(),
                                com.malushkoaa.core.R.color.white
                            )
                        )
                    }
                }
            }
        }.attach()
        
        binding.tabSelectCategory.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.customView?.apply {
                    findViewById<ImageView>(R.id.tabLayoutCircle).setColorFilter(
                        ContextCompat.getColor(
                            requireContext(),
                            com.malushkoaa.core.R.color.primary
                        )
                    )
                    findViewById<TextView>(R.id.tabTV).setTextColor(Color.parseColor("#FF6E4E"))
                    findViewById<ImageView>(R.id.tabIV).setColorFilter(
                        ContextCompat.getColor(
                            requireContext(),
                            com.malushkoaa.core.R.color.white
                        )
                    )
                }
            }
            
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.customView?.apply {
                    findViewById<ImageView>(R.id.tabLayoutCircle)
                        ?.setColorFilter(
                            ContextCompat.getColor(
                                requireContext(),
                                com.malushkoaa.core.R.color.white
                            )
                        )
                    findViewById<TextView>(R.id.tabTV)
                        ?.setTextColor(Color.parseColor("#B3B3C3"))
                    findViewById<ImageView>(R.id.tabIV)
                        ?.setColorFilter(
                            ContextCompat.getColor(
                                requireContext(),
                                com.malushkoaa.core.R.color.tab_layout_icon_color
                            )
                        )
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
        binding.mainScreenCategoriesContentViewPager.isUserInputEnabled = false
    }
    
    private fun initBottomNavBar() {
        binding.bottomNavBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragmentCart -> {
                    findNavController().navigate(com.malushkoaa.navigation.R.id.action_mainFragment_to_detailsFragment)
                    true
                }
                else -> true
            }
        }
        
        val badge = binding.bottomNavBar.getOrCreateBadge(R.id.fragmentCart)
        with(badge) {
            mainViewModel.cartItemsCount.observe(viewLifecycleOwner) {
                number = it
                isVisible = true
            }
        }
    }
    
    private fun openFilterController() {
        binding.bottomNavBar.visibility = View.INVISIBLE
        with(binding.filterOptionsCard) {
            filterOptions.visibility = View.VISIBLE
            btnFilterCloser.setOnClickListener {
                binding.filterOptionsCard.filterOptions.visibility = View.GONE
                binding.bottomNavBar.visibility = View.VISIBLE
            }
            btnFilterDone.setOnClickListener {
                binding.filterOptionsCard.filterOptions.visibility = View.GONE
                Toast.makeText(context, "Your filters are accepted", Toast.LENGTH_SHORT).show()
                binding.bottomNavBar.visibility = View.VISIBLE
            }
        }
    }
    
    
}