package com.vvwxx.bangkit.mytablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    // Untuk tampilan judul tab
    companion object {
        private val TAB_TITLE = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_4,
            R.string.tab_text_2,
            R.string.tab_text_3
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // menghubungkan SectionPagerAdapter dengan ViewPager2
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)

        sectionsPagerAdapter.appName = resources.getString(R.string.app_name) // masukkan data yang ingin dikirim dari activity

        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)

        // menghubungkan ViewPager2 dengan TabLayout
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLE[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }
}