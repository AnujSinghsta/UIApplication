package com.example.myapplication.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.MyAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentNotificationsBinding
import com.google.android.material.tabs.TabLayout

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        tabLayout = root.findViewById<TabLayout>(R.id.tabLayout)
        viewPager = root.findViewById<ViewPager>(R.id.viewPager)
        viewpager()
        return root
    }

    private fun viewpager() {


        tabLayout!!.addTab(tabLayout!!.newTab().setText("Today "))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Yesterday"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = fragmentManager?.let {
            MyAdapterTraction(
                requireActivity(),
                it,
                tabLayout!!.tabCount
            )
        }
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}