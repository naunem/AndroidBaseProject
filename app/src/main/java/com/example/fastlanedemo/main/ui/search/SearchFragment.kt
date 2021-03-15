package com.example.fastlanedemo.main.ui.search

import android.os.Bundle
import android.view.View
import com.example.fastlanedemo.R
import com.example.fastlanedemo.databinding.FragmentSearchBinding
import com.example.fastlanedemo.main.extensions.navigate
import com.example.fastlanedemo.main.ui.base.BaseFragment

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
