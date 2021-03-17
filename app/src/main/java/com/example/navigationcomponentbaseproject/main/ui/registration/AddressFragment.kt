package com.example.navigationcomponentbaseproject.main.ui.registration

import android.os.Bundle
import android.view.View
import com.example.navigationcomponentbaseproject.R
import com.example.navigationcomponentbaseproject.databinding.FragmentAddressBinding
import com.example.navigationcomponentbaseproject.main.ui.base.BaseFragment

class AddressFragment : BaseFragment<FragmentAddressBinding>(R.layout.fragment_address) {

    override fun getViewBinding(): FragmentAddressBinding =
        FragmentAddressBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDone.setOnClickListener {

        }
    }
}
