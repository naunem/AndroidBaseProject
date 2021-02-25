package com.example.fastlanedemo.main.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.example.fastlanedemo.R
import com.example.fastlanedemo.main.extensions.superNavHostFragment

abstract class BaseFragment<T : ViewBinding>(@LayoutRes private val layoutResId: Int) :
    Fragment(layoutResId) {
    private var _binding: T? = null

    val binding get() = _binding!!
    private val backPressedCallback =
        object : OnBackPressedCallback(true /* enabled by default */) {
            override fun handleOnBackPressed() {
                handleBackPressed()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return createViewForFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            backPressedCallback
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun getViewBinding(): T

    protected open fun handleBackPressed() {
        findNavController().navigateUp()
    }

    private fun createViewForFragment(): View {
        _binding = getViewBinding()
        return binding.root
    }
}
