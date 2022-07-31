package com.malushkoaa.feature_details.presentation.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.malushkoaa.core.App
import com.malushkoaa.core.di.ViewModelFactory
import com.malushkoaa.feature_details.R
import com.malushkoaa.feature_details.databinding.FragmentDetailsBinding
import com.malushkoaa.feature_details.di.DaggerDetailsComponent
import com.malushkoaa.feature_details.domain.entities.DetailsResponse
import com.malushkoaa.feature_details.domain.entities.ItemCapacity
import com.malushkoaa.feature_details.domain.entities.ItemColors
import com.malushkoaa.feature_details.presentation.ProductDetailsState
import com.malushkoaa.feature_details.presentation.adapters.capacity.CapacityAdapter
import com.malushkoaa.feature_details.presentation.adapters.colors.ColorsAdapter
import com.malushkoaa.feature_details.presentation.adapters.imagespager.ImagesAdapter
import com.malushkoaa.feature_details.presentation.viewmodels.DetailsViewModel
import java.text.DecimalFormat
import javax.inject.Inject

class DetailsFragment : Fragment() {
    
    private lateinit var detailsViewModel: DetailsViewModel
    
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    
    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailsBinding is null")
    
    override fun onAttach(context: Context) {
        DaggerDetailsComponent.builder()
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
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailsViewModel = ViewModelProvider(this, viewModelFactory)[DetailsViewModel::class.java]
        detailsViewModel.getProductData()
        bindButtons()
        observeViewModel()
    }
    
    private fun bindButtons() {
        with(binding) {
            btnBack.setOnClickListener { findNavController().popBackStack() }
            btnCart.setOnClickListener { TODO() }
        }
    }
    
    private fun observeViewModel() {
        detailsViewModel.productDetails.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            when (it) {
                is ProductDetailsState.Progress -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is ProductDetailsState.ProductResult -> {
                    val result = it.data
                    initImagesAdapter(result.images)
                    initData(result)
                    initColorsAdapter(result.color)
                    initCapacityAdapter(result.capacity)
                }
                is ProductDetailsState.Error -> {
                    showAlertDialog()
                }
            }
        }
    }
    
    private fun initImagesAdapter(imagesList: List<String>?) {
        val imagesAdapter = ImagesAdapter(imagesList!!)
        val pageTransformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(60))
            addTransformer { page, position ->
                val r = 1 - Math.abs(position)
                page.scaleY = 0.85f + r * 0.15f
            }
        }
        with(binding.detailsScreenViewPager) {
            adapter = imagesAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            offscreenPageLimit = 3
            setPageTransformer(pageTransformer)
        }
    }
    
    private fun initColorsAdapter(colorsList: List<ItemColors>?) {
        val colorsAdapter = ColorsAdapter()
        colorsAdapter.colorsList = colorsList!!
        binding.rvSelectColor.adapter = colorsAdapter
    }
    
    private fun initCapacityAdapter(capacityList: List<ItemCapacity>?) {
        val capacityAdapter = CapacityAdapter(context!!)
        capacityAdapter.capacitiesList = capacityList!!
        binding.rvSelectCapacity.adapter = capacityAdapter
    }
    
    private fun initData(product: DetailsResponse) {
        with(binding) {
            ratingBar.rating = product.rating.toString().toFloat()
            tvTitle.text = product.title
            tvCpu.text = product.cpu
            tvCamera.text = product.camera
            tvRam.text = product.ssd
            tvRom.text = product.sd
            if (product.isFavorites == true) {
                btnFavorite.setIconResource(com.malushkoaa.core.R.drawable.ic_favorite)
            }
            btnFavorite.setOnClickListener {
                detailsViewModel.toFavoritesClick(product)
                if (product.isFavorites == true) {
                    btnFavorite.setIconResource(com.malushkoaa.core.R.drawable.ic_favorite)
                } else {
                    btnFavorite.setIconResource(com.malushkoaa.core.R.drawable.ic_favorite_not)
                }
            }
            btnAddToCart.text = resources.getString(
                R.string.btn_add_to_cart_text,
                DecimalFormat("#,###.00").format(product.price)
            )
        }
    }
    
    private fun showAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(com.malushkoaa.core.R.string.alert_title)
            .setMessage(com.malushkoaa.core.R.string.alert_message)
            .setPositiveButton(com.malushkoaa.core.R.string.alert_btn) { _, _ -> detailsViewModel.getProductData() }
            .setCancelable(false)
            .show()
    }
    
}