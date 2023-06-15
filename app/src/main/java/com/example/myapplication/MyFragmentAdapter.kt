package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyFragmentAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    companion object{
        const val NUM_ITEMS = 3
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment1()
            1 -> return SportFragment1()
        }
        return HomeFragment1()
    }

    override fun getCount(): Int {
        return  NUM_ITEMS
    }
}