package com.example.fastlanedemo.main.ui.registration

import android.os.Bundle
import android.view.View
import com.example.fastlanedemo.R
import com.example.fastlanedemo.databinding.FragmentInfoBinding
import com.example.fastlanedemo.main.extensions.navigate
import com.example.fastlanedemo.main.ui.base.BaseFragment

class InfoFragment : BaseFragment<FragmentInfoBinding>(R.layout.fragment_info) {
    override fun getViewBinding(): FragmentInfoBinding = FragmentInfoBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            navigate(R.id.action_infoFragment_to_addressFragment)
        }
    }
}
