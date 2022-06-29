package com.jmy.finders4

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jmy.finders4.databinding.FragmentListBinding


class ListFragment : Fragment() {
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater, container, false)
        val poleListData: MutableList<Pole> = mainActivity.loadData()
        var poleListAdapter = PoleListAdapter()
        poleListAdapter.listData = poleListData

        binding.recyclerView.adapter = poleListAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(mainActivity)
        return binding.root
    }
}