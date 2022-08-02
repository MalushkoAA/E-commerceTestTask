package com.malushkoaa.feature_main.presentation.screens.categoriescontent

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.malushkoaa.core.App
import com.malushkoaa.core.di.ViewModelFactory
import com.malushkoaa.feature_main.databinding.FragmentPhonesBinding
import com.malushkoaa.feature_main.di.DaggerMainComponent
import com.malushkoaa.feature_main.domain.entities.BestSeller
import com.malushkoaa.feature_main.domain.entities.HotSale
import com.malushkoaa.feature_main.presentation.CategoriesResponseState
import com.malushkoaa.feature_main.presentation.adapters.bestselleradapter.BestSellerAdapter
import com.malushkoaa.feature_main.presentation.adapters.hotsaleadapter.HotSaleAdapter
import com.malushkoaa.feature_main.presentation.viewmodels.PhonesViewModel
import javax.inject.Inject

class PhonesFragment : Fragment() {
    
    private lateinit var phonesViewModel: PhonesViewModel
    
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    
    private var _binding: FragmentPhonesBinding? = null
    private val binding: FragmentPhonesBinding
        get() = _binding ?: throw RuntimeException("FragmentPhonesBinding is null")
    
    
    override fun onAttach(context: Context) {
        DaggerMainComponent.builder()
            .coreComponent((requireActivity().application as App).coreComponent)
            .build()
            .inject(this)
        super.onAttach(context)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhonesBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phonesViewModel = ViewModelProvider(this, viewModelFactory)[PhonesViewModel::class.java]
        
        phonesViewModel.startRequest()
        observeViewModel()
    }
    
    private fun observeViewModel() {
        phonesViewModel.categoriesResponseState.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            when (it) {
                is CategoriesResponseState.Progress -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is CategoriesResponseState.PhonesResult -> {
                    initHotSalesAdapter(it.data.hotSale)
                    initBestSellerAdapter(it.data.bestSeller)
                }
                is CategoriesResponseState.Error -> {
                    showAlertDialog()
                }
            }
        }
    }
    
    private fun initHotSalesAdapter(hotSale: List<HotSale>?) {
        val hotSalesAdapter = HotSaleAdapter()
        binding.viewPagerHotSales.adapter = hotSalesAdapter
        binding.viewPagerHotSales.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        hotSalesAdapter.submitList(hotSale)
    }
    
    private fun initBestSellerAdapter(bestSellerList: List<BestSeller>?) {
        val bestSellerAdapter = BestSellerAdapter(context)
        binding.rvBestSeller.adapter = bestSellerAdapter
        bestSellerAdapter.onFavoriteClick = {
            phonesViewModel.onBestSellerFavoriteClick(it)
        }
        bestSellerAdapter.onBestSellerClick = {
            findNavController().navigate(com.malushkoaa.navigation.R.id.action_mainFragment_to_detailsFragment)
        }
        bestSellerAdapter.submitList(bestSellerList)
    }
    
    private fun showAlertDialog(){
        AlertDialog.Builder(requireContext())
            .setTitle(com.malushkoaa.core.R.string.alert_title)
            .setMessage(com.malushkoaa.core.R.string.alert_message)
            .setPositiveButton(com.malushkoaa.core.R.string.alert_btn) { _, _ -> phonesViewModel.startRequest() }
            .setCancelable(false)
            .show()
    }
    
}