package com.example.rush

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rush.adapter.RecyclerViewAdapter
import com.example.rush.databinding.FragmentHomeBinding
import com.example.rush.dataclasses.AppCategory


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeRecyclerView: RecyclerView
    private  lateinit var appCategoryArray : ArrayList<AppCategory>
    lateinit var appCategoryImages : Array<Int>
    lateinit var appCategoryNames : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)







        return binding.root






       // getData()






    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        appCategoryImages = arrayOf(
            R.drawable.docs,
            R.drawable.filemanager,
            R.drawable.ic_globe,
            R.drawable.social,
            R.drawable.more,
            R.drawable.ic_message_square,
            R.drawable.storage
        )

        appCategoryNames = arrayOf(
            "Documents",
            "File Managers",
            "Browsers",
            "Social Media",
            "More",
            "Messaging",

            "Cloud"

        )
        appCategoryArray = arrayListOf<AppCategory>()

        for (i in appCategoryImages.indices ) {
            val appCategory = AppCategory(appCategoryImages[i],appCategoryNames[i])
            appCategoryArray.add(appCategory)
        }


        homeRecyclerView = binding.mainRecyclerview
        homeRecyclerView.adapter = RecyclerViewAdapter(appCategoryArray)
        homeRecyclerView.layoutManager = GridLayoutManager(context,2)
        homeRecyclerView.setHasFixedSize(true)

    }



    private fun getData() {

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}