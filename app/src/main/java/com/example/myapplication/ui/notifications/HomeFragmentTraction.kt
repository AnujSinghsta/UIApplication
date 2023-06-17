package com.example.myapplication.ui.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ItemsViewModel
import com.example.myapplication.R


class HomeFragmentTraction : Fragment() ,listner{
    var recyclerview: RecyclerView? =null;

    override fun onStart() {
        super.onStart()
        ma();
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_home1, container, false)

         recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview?.layoutManager = LinearLayoutManager(requireActivity())
        return  view;
    }

    private fun  ma() {
        val data = ArrayList<ItemsViewModel>()


        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.downloadnew, "Item " + i))
        }

        val adapter = CustomAdapterTarction(data ,this)
        recyclerview?.adapter = adapter
    }

    override fun onClickListner() {

        findNavController().navigate(R.id.action_navigation_notifications_to_billDetailsFragment)

    }


}