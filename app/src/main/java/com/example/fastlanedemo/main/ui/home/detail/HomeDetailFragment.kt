package com.example.fastlanedemo.main.ui.home.detail

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.fastlanedemo.R
import com.example.fastlanedemo.databinding.FragmentHomeDetailBinding
import com.example.fastlanedemo.main.extensions.superNavHostFragment
import com.example.fastlanedemo.main.ui.base.BaseFragment

class HomeDetailFragment : BaseFragment<FragmentHomeDetailBinding>(R.layout.fragment_home_detail) {

    override fun getViewBinding(): FragmentHomeDetailBinding =
        FragmentHomeDetailBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            superNavHostFragment().findNavController().setGraph(R.navigation.registration_nav_graph)
        }
    }

    override fun handleBackPressed() {
        AlertDialog.Builder(context).apply {
            setMessage("Do you want to exit?")
            setPositiveButton("OK") { _, _ ->
                super.handleBackPressed()
            }
            setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
        }.show()
    }
}
