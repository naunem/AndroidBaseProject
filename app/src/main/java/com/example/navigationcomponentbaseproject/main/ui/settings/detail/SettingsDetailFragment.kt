package com.example.navigationcomponentbaseproject.main.ui.settings.detail

import com.example.navigationcomponentbaseproject.R
import com.example.navigationcomponentbaseproject.databinding.FragmentSearchDetailBinding
import com.example.navigationcomponentbaseproject.main.ui.base.BaseFragment

class SettingsDetailFragment: BaseFragment<FragmentSearchDetailBinding>(R.layout.fragment_settings_detail) {
    override fun getViewBinding(): FragmentSearchDetailBinding = FragmentSearchDetailBinding.inflate(layoutInflater)
}
