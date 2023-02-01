package com.rtech.sportapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rtech.sportapp.adapter.ViewPagerAdapter
import com.rtech.sportapp.databinding.ActivityDetailBinding
import com.rtech.sportapp.fragment.TeamAFragment
import com.rtech.sportapp.fragment.TeamBFragment
import com.rtech.sportapp.fragment.TeamCFragment
import com.rtech.sportapp.fragment.TeamDFragment

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    val adapter = ViewPagerAdapter(supportFragmentManager)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ss:String = intent.getStringExtra("teamName").toString()
        val ss1:String = intent.getStringExtra("teamName2").toString()
        val sharedValue:String = intent.getStringExtra("sharedvalue").toString()
        if (sharedValue.equals("sharedValue")){
            adapter.addFragment(TeamCFragment(),ss)
            adapter.addFragment(TeamDFragment(),ss1)
        }else{
            adapter.addFragment(TeamAFragment(),ss)
            adapter.addFragment(TeamBFragment(),ss1)
        }

        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.tvPressback.setOnClickListener{
            finish()
        }

    }
}