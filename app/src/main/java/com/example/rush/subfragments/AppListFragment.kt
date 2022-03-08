package com.example.rush.subfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rush.R
import com.example.rush.databinding.FragmentAppListBinding
import com.example.rush.dataclasses.AppNameClass
import com.example.rush.subfragments.placeholder.PlaceholderContent

class AppListFragment : Fragment() {

    private var columnCount = 1

    private lateinit var binding: FragmentAppListBinding
    private lateinit var appListRecyclerView: RecyclerView
    private lateinit var appListArrayList: ArrayList<AppNameClass>
    private lateinit var mapOfApps : Map<String,ArrayList<AppNameClass>>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAppListBinding.inflate(layoutInflater)
       // val view = inflater.inflate(R.layout.fragment_app_list_list, container, false)

        return  binding.root

    }

    companion object {

        @JvmStatic
        fun newInstance(columnCount: Int) =
            AppListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}