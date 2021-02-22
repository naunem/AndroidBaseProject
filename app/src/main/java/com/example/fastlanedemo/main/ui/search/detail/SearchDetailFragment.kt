package com.example.fastlanedemo.main.ui.search.detail

import com.example.fastlanedemo.R
import com.example.fastlanedemo.databinding.FragmentSearchDetailBinding
import com.example.fastlanedemo.main.ui.base.BaseFragment

class SearchDetailFragment: BaseFragment<FragmentSearchDetailBinding>(R.layout.fragment_search_detail) {
    override fun getViewBinding(): FragmentSearchDetailBinding = FragmentSearchDetailBinding.inflate(layoutInflater)
}
