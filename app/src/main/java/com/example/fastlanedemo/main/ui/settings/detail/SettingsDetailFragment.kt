package com.example.fastlanedemo.main.ui.settings.detail

import com.example.fastlanedemo.R
import com.example.fastlanedemo.databinding.FragmentSearchDetailBinding
import com.example.fastlanedemo.main.ui.base.BaseFragment

class SettingsDetailFragment: BaseFragment<FragmentSearchDetailBinding>(R.layout.fragment_settings_detail) {
    override fun getViewBinding(): FragmentSearchDetailBinding = FragmentSearchDetailBinding.inflate(layoutInflater)
}
