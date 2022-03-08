package com.example.rush

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rush.adapter.RecyclerViewAdapter
import com.example.rush.databinding.FragmentHomeBinding
import com.example.rush.dataclasses.AppCategory


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
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        appCategoryImages = arrayOf(
            R.drawable.docs,
            R.drawable.filemanager,
            R.drawable.ic_globe,
            R.drawable.social,

            R.drawable.ic_message_square,
            R.drawable.storage,
            R.drawable.more,
        )

        appCategoryNames = arrayOf(
            "Documents",
            "File Managers",
            "Browsers",
            "Social Media",

            "Messaging",
            "Cloud",
            "More"


            )
        appCategoryArray = arrayListOf<AppCategory>()


        for (i in appCategoryImages.indices) {
            val appCategory = AppCategory(appCategoryImages[i], appCategoryNames[i])
            appCategoryArray.add(appCategory)
        }


        homeRecyclerView = binding.mainRecyclerview
        homeRecyclerView.adapter = RecyclerViewAdapter(appCategoryArray,this)
        homeRecyclerView.layoutManager = GridLayoutManager(context, 2)
        homeRecyclerView.setHasFixedSize(true)

    }

    override fun onCardClick(position: Int) {
        Toast.makeText(context, "Heyyyy",Toast.LENGTH_SHORT).show()

        view?.let { Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_appListFragment) }


    }

    private fun setCurrentFragment(fragment: Fragment)  {

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