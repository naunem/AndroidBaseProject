package com.example.fastlanedemo.main.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.fastlanedemo.MainActivity
import com.example.fastlanedemo.R
import com.example.fastlanedemo.databinding.FragmentLoginBinding
import com.example.fastlanedemo.main.ui.base.BaseFragment

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