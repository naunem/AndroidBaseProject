package com.example.navigationcomponentbaseproject

import android.os.Bundle
import com.example.navigationcomponentbaseproject.databinding.ActivityLauncherBinding
import com.example.navigationcomponentbaseproject.main.extensions.viewBinding
import com.example.navigationcomponentbaseproject.main.ui.base.BaseActivity

class LauncherActivity : BaseActivity() {
    private val binding by viewBinding(ActivityLauncherBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
