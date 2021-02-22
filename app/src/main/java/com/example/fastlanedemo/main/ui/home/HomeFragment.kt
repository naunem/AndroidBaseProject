package com.example.fastlanedemo.main.ui.home

import android.os.Bundle
import android.view.View
import com.example.fastlanedemo.R
import com.example.fastlanedemo.databinding.FragmentHomeBinding
import com.example.fastlanedemo.main.extensions.navigate
import com.example.fastlanedemo.main.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHome.apply {
            text = "navigate to home detail"
            setOnClickListener {
                navigate(R.id.action_homeFragment_to_homeDetailFragment)
            }
        }
    }
}
