package com.example.fragmentwithtablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentwithtablayout.databinding.ActivityMainBinding
import com.example.fragmentwithtablayout.fragments.Home2Fragment
import com.example.fragmentwithtablayout.fragments.HomeFragment
import com.google.android.material.tabs.TabLayout

@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayout = binding.tabLayout

        tabLayout.addTab(tabLayout.newTab().setText("First Tab"))
        tabLayout.addTab(tabLayout.newTab().setText("Second Tab"))

        setDefaultTab(HomeFragment())
        setOnTabClickedListener(HomeFragment())

        
    }

    private fun setDefaultTab(fragment: HomeFragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commitNow()
    }


    private fun setOnTabClickedListener(fragment: HomeFragment){
        binding.tabLayout.addOnTabSelectedListener(object:
            TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val fragment = when(tab?.position){
                    0-> {
                        HomeFragment()
                    }
                    else -> {
                        Home2Fragment()
                    }
                }

                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

}