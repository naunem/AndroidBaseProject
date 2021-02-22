package com.example.fastlanedemo.main.ui.settings

import com.example.fastlanedemo.R
import com.example.fastlanedemo.databinding.FragmentSettingsBinding
import com.example.fastlanedemo.main.ui.base.BaseFragment

class SettingsFragment : BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings) {

    override fun getViewBinding(): FragmentSettingsBinding =
        FragmentSettingsBinding.inflate(layoutInflater)
}
