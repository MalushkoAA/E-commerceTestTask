package com.malushkoaa.feature_main.presentation.screens.categoriescontent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.malushkoaa.feature_main.databinding.FragmentEmptyBinding

class EmptyFragment : Fragment() {

    private var _binding: FragmentEmptyBinding? = null
    private val binding: FragmentEmptyBinding
        get() = _binding ?: throw RuntimeException("FragmentEmptyBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmptyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(binding.ivEmpty)
            .load(com.malushkoaa.core.R.drawable.under_construction)
            .into(binding.ivEmpty)
    }
}