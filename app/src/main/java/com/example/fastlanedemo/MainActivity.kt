package com.example.fastlanedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.fastlanedemo.databinding.ActivityMainBinding
import com.example.fastlanedemo.main.extensions.setupWithNavController
import com.example.fastlanedemo.main.extensions.viewBinding

class MainActivity : AppCompatActivity() {

    private var currentNavController: LiveData<NavController>? = null
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
            setupActionBarWithNavController(navController)
        })
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        println("xxxxxx onSupportNavigateUp: ${currentNavController?.value}")
        return currentNavController?.value?.navigateUp() ?: false
    }
}
