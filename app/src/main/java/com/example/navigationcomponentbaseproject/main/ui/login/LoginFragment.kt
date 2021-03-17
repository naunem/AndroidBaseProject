package com.example.navigationcomponentbaseproject.main.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.navigationcomponentbaseproject.MainActivity
import com.example.navigationcomponentbaseproject.R
import com.example.navigationcomponentbaseproject.databinding.FragmentLoginBinding
import com.example.navigationcomponentbaseproject.main.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    override fun getViewBinding(): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener {
            activity?.run {
                startActivity(Intent(this, MainActivity::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }
        }
    }
}