package com.malushkoaa.feature_my_cart.presentation.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.malushkoaa.core.App
import com.malushkoaa.core.di.ViewModelFactory
import com.malushkoaa.feature_my_cart.databinding.FragmentCartBinding
import com.malushkoaa.feature_my_cart.di.DaggerCartComponent
import com.malushkoaa.feature_my_cart.domain.entities.CartResponse
import com.malushkoaa.feature_my_cart.domain.entities.ItemBasket
import com.malushkoaa.feature_my_cart.presentation.CartDataState
import com.malushkoaa.feature_my_cart.presentation.adapters.CartAdapter
import com.malushkoaa.feature_my_cart.presentation.viewmodels.CartViewModel
import java.text.DecimalFormat
import javax.inject.Inject


class CartFragment : Fragment() {
    
    private lateinit var cartViewModel: CartViewModel
    
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    
    private var _binding: FragmentCartBinding? = null
    private val binding: FragmentCartBinding
        get() = _binding ?: throw RuntimeException("FragmentCartBinding is null")
    
    override fun onAttach(context: Context) {
        DaggerCartComponent.builder()
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
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cartViewModel = ViewModelProvider(this, viewModelFactory)[CartViewModel::class.java]
        
        cartViewModel.getCartResponse()
        bindButtons()
        observeViewModel()
    }
    
    private fun bindButtons() {
        with(binding) {
            btnBack.setOnClickListener { findNavController().popBackStack() }
        }
    }
    
    private fun observeViewModel() {
        cartViewModel.cartData.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            when (it) {
                is CartDataState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is CartDataState.SuccessResponse -> {
                    val data = it.response
                    initCartAdapter(data.itemBasket)
                    initData(data)
                }
                is CartDataState.Error -> {
                    showAlertDialog()
                }
            }
        }
    }
    
    private fun initCartAdapter(itemBasket: List<ItemBasket>?) {
        val cartAdapter = CartAdapter()
        binding.rvCart.adapter = cartAdapter
        cartAdapter.submitList(itemBasket)
        
    }
    
    private fun showAlertDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle(com.malushkoaa.core.R.string.alert_title)
            .setMessage(com.malushkoaa.core.R.string.alert_message)
            .setPositiveButton(com.malushkoaa.core.R.string.alert_btn) { _, _ -> cartViewModel.getCartResponse() }
            .setCancelable(false)
            .show()
    }
    
    private fun initData(data:CartResponse){
        with(binding){
            tvPriceTotal.text="$${DecimalFormat("#,###").format(data.total)} US"
            tvDeliveryPrice.text=data.delivery
        }
    }
}