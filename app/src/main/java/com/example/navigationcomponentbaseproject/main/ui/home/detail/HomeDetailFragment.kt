package com.example.navigationcomponentbaseproject.main.ui.home.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentbaseproject.R
import com.example.navigationcomponentbaseproject.databinding.FragmentHomeDetailBinding
import com.example.navigationcomponentbaseproject.main.extensions.superNavHostFragment
import com.example.navigationcomponentbaseproject.main.ui.base.BaseFragment

class HomeDetailFragment : BaseFragment<FragmentHomeDetailBinding>(R.layout.fragment_home_detail) {

    override fun getViewBinding(): FragmentHomeDetailBinding =
        FragmentHomeDetailBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            superNavHostFragment().findNavController().setGraph(R.navigation.registration_nav_graph)
        }
    }
}
