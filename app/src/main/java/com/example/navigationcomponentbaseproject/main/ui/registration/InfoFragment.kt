package com.example.navigationcomponentbaseproject.main.ui.registration

import android.os.Bundle
import android.view.View
import com.example.navigationcomponentbaseproject.R
import com.example.navigationcomponentbaseproject.databinding.FragmentInfoBinding
import com.example.navigationcomponentbaseproject.main.extensions.navigate
import com.example.navigationcomponentbaseproject.main.ui.base.BaseFragment

class InfoFragment : BaseFragment<FragmentInfoBinding>(R.layout.fragment_info) {
    override fun getViewBinding(): FragmentInfoBinding = FragmentInfoBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            navigate(R.id.action_infoFragment_to_addressFragment)
        }
    }
}
