package com.example.rush

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rush.adapter.RecyclerViewAdapter
import com.example.rush.databinding.FragmentHomeBinding
import com.example.rush.dataclasses.AppCategory
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(),RecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeRecyclerView: RecyclerView
    private lateinit var appCategoryArray: ArrayList<AppCategory>
    private lateinit var appCategoryImages: Array<Int>
    private lateinit var appCategoryNames: Array<String>





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        appCategoryImages = arrayOf(
            R.drawable.ic_globe,
            R.drawable.social,
            R.drawable.ic_message_square,
           // R.drawable.docs,
            R.drawable.filemanager,

            R.drawable.storage,
            R.drawable.ic_imaging,
            R.drawable.ic_tv,
            R.drawable.shopping,
            R.drawable.more,
        )

        appCategoryNames = arrayOf(
            "Browsers",
            "Social Media",
            "Messaging",
            //"Documents",
            "File Managers",
            "Cloud",
            "Imaging",
            "Media & Streaming",
            "Shopping",
            "More"


            )
        appCategoryArray = arrayListOf()


        for (i in appCategoryImages.indices) {
            val appCategory = AppCategory(appCategoryImages[i], appCategoryNames[i])
            appCategoryArray.add(appCategory)
        }



        homeRecyclerView = binding.mainRecyclerview
        homeRecyclerView.adapter = RecyclerViewAdapter(appCategoryArray, this)
        homeRecyclerView.layoutManager = GridLayoutManager(context, 2)
        homeRecyclerView.setHasFixedSize(true)

    }

    //val switchButton = binding.switchLayout.setOnClickListener {  }



    override fun onCardClick(position: Int) {
        Toast.makeText(context, "Hey",Toast.LENGTH_SHORT).show()

        val action =

            view?.findNavController()?.navigate(HomeFragmentDirections.actionHomeFragmentToAllAppListFragment(position))

        //view?.let { Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_allAppListFragment) }


    }


    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}