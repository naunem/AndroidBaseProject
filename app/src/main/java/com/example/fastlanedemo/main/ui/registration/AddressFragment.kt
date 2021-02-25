package com.example.fastlanedemo.main.ui.registration

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.fastlanedemo.R
import com.example.fastlanedemo.databinding.FragmentAddressBinding
import com.example.fastlanedemo.main.extensions.superNavHostFragment
import com.example.fastlanedemo.main.ui.base.BaseFragment

class AddressFragment : BaseFragment<FragmentAddressBinding>(R.layout.fragment_address) {

    override fun getViewBinding(): FragmentAddressBinding =
        FragmentAddressBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDone.setOnClickListener {

        }
    }
}
