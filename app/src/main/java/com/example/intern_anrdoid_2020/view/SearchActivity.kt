package com.example.intern_anrdoid_2020.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.intern_anrdoid_2020.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        showsSearchFragment()
        setupBottomNavigation()
    }

    private fun showsSearchFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.search_layout_frame, SearchFragment())
                .addToBackStack(null)
                .commit()
    }

    private fun showsQuestion1SearchFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.search_layout_frame, Question1SearchFragment())
                .addToBackStack(null)
                .commit()
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = navigation
        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            item.isChecked = true
            when (item.itemId) {
                R.id.nab_setting -> {
                    showsSearchFragment()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_list -> {
                    showsQuestion1SearchFragment()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }

    companion object {
        fun createIntent(context: Context?): Intent {
            return Intent(context, SearchActivity::class.java)
        }
    }
}
