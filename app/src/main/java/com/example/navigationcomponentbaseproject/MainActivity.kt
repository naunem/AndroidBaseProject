package com.example.navigationcomponentbaseproject

import android.os.Bundle
import com.example.navigationcomponentbaseproject.databinding.ActivityMainBinding
import com.example.navigationcomponentbaseproject.main.extensions.viewBinding
import com.example.navigationcomponentbaseproject.main.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val navGraphIds = listOf(
            R.navigation.home_nav_graph,
            R.navigation.search_nav_graph,
            R.navigation.settings_nav_graph
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = binding.bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.navHostContainer,
            intent = intent
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this, { navController ->
//            navController.add
        })
    }
}
