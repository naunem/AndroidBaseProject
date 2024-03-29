package com.example.navigationcomponentbaseproject.main.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.navigationcomponentbaseproject.R
import com.example.navigationcomponentbaseproject.databinding.FragmentSplashBinding
import com.example.navigationcomponentbaseproject.main.extensions.navigate
import com.example.navigationcomponentbaseproject.main.ui.base.BaseFragment

class SplashFragment : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    override fun getViewBinding(): FragmentSplashBinding =
        FragmentSplashBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigateLogin()
    }

    private fun navigateLogin() {
        Handler(Looper.getMainLooper()).postDelayed({
            navigate(R.id.action_splashFragment_to_loginFragment)
        }, 3000)
    }
}
