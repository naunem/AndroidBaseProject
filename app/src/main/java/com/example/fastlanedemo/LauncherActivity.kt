package com.example.fastlanedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fastlanedemo.databinding.ActivityLauncherBinding
import com.example.fastlanedemo.main.extensions.viewBinding
import com.example.fastlanedemo.main.ui.base.BaseActivity

class LauncherActivity : BaseActivity() {
    private val binding by viewBinding(ActivityLauncherBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
