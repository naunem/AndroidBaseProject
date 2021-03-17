package com.example.navigationcomponentbaseproject.main.ui.search.detail

import android.os.Bundle
import android.view.View
import com.example.navigationcomponentbaseproject.R
import com.example.navigationcomponentbaseproject.databinding.FragmentSearchDetailBinding
import com.example.navigationcomponentbaseproject.main.ui.base.BaseFragment

class SearchDetailFragment :
    BaseFragment<FragmentSearchDetailBinding>(R.layout.fragment_search_detail) {
    override fun getViewBinding(): FragmentSearchDetailBinding =
        FragmentSearchDetailBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTitle.text = arguments?.let {
            SearchDetailFragmentArgs.fromBundle(it).keySearch
        }
    }
}
