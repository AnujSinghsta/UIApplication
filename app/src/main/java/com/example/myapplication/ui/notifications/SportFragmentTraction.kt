package com.example.myapplication.ui.notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.ItemsViewModel
import com.example.myapplication.R


class SportFragmentTraction : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_sport1, container, false)
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(requireActivity())

        val data = ArrayList<ItemsViewModel>()


        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.storelogo, "Item " + i))
        }

        val adapter = CustomAdapterTarction(data)

        recyclerview.adapter = adapter

        return  view;
    }

}