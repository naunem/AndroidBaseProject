package com.example.navigationcomponentbaseproject.main.ui.search

import android.os.Bundle
import android.view.View
import com.example.navigationcomponentbaseproject.R
import com.example.navigationcomponentbaseproject.databinding.FragmentSearchBinding
import com.example.navigationcomponentbaseproject.main.extensions.navigate
import com.example.navigationcomponentbaseproject.main.ui.base.BaseFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    override fun getViewBinding(): FragmentSearchBinding =
        FragmentSearchBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.btnSearch.setOnClickListener {
            val action =
                SearchFragmentDirections.actionSearchFragmentToSearchDetailFragment(binding.edtSearch.text.toString())
            navigate(action)
        }
    }

}
