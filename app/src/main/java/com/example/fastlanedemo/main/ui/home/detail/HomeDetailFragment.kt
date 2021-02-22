package com.example.fastlanedemo.main.ui.home.detail

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fastlanedemo.R
import com.example.fastlanedemo.databinding.FragmentHomeDetailBinding
import com.example.fastlanedemo.main.ui.base.BaseFragment

class HomeDetailFragment : BaseFragment<FragmentHomeDetailBinding>(R.layout.fragment_home_detail) {

    override fun getViewBinding(): FragmentHomeDetailBinding =
        FragmentHomeDetailBinding.inflate(layoutInflater)

    override fun handleBackPressed() {
        AlertDialog.Builder(context).apply {
            setMessage("Do you want to exit?")
            setPositiveButton("OK") { _, _ ->
                findNavController().popBackStack()
            }
            setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
        }.show()
    }
}
