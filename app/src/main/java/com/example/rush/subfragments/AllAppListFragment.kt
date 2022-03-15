package com.example.rush.subfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rush.R
import com.example.rush.adapter.ApplListRecyclerView
import com.example.rush.databinding.FragmentAllAppListBinding
import com.example.rush.databinding.FragmentHomeBinding
import com.example.rush.dataclasses.AppCategory
import com.example.rush.mvvm.*


class AllAppListFragment : Fragment() {

    lateinit var binding: FragmentAllAppListBinding
    lateinit var appsViewModel: AppsViewModel
    private lateinit var browserList: ArrayList<AppCategory>
    private lateinit var socialMediaList: ArrayList<AppCategory>
    private lateinit var messengersList: ArrayList<AppCategory>
    private lateinit var fileManagersList: ArrayList<AppCategory>
    private lateinit var cloudAppsList: ArrayList<AppCategory>
    private lateinit var imagingAppsList: ArrayList<AppCategory>
    private lateinit var mediaAndStreamAppsList: ArrayList<AppCategory>
    private lateinit var paymentAppsList: ArrayList<AppCategory>
    private lateinit var shoppingAppsList: ArrayList<AppCategory>
    private val args: AllAppListFragmentArgs by navArgs()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAllAppListBinding.inflate(layoutInflater)
        val dataFromHome: Int = args.appType


        val appCategoryNames = arrayOf(
            "Browsers",
            "Social Media",
            "Messaging",
//            "Documents",
            "File Managers",
            "Cloud",
            "More"


        )
        binding.data = appCategoryNames[dataFromHome].toString()

        return binding.root


        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_all_app_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = activity?.let { AppsDataBase.getDatabase(it.applicationContext).appsDao() }
        val repository = dao?.let { AppsRepository(it) }


        appsViewModel = ViewModelProvider(
            this,
            AppsViewModelFactory(repository!!)
        ).get(AppsViewModel::class.java)






        browserList = arrayListOf()
        socialMediaList = arrayListOf()
        messengersList = arrayListOf()
        fileManagersList = arrayListOf()
        cloudAppsList = arrayListOf()
        imagingAppsList = arrayListOf()
        mediaAndStreamAppsList = arrayListOf()
        paymentAppsList = arrayListOf()
        shoppingAppsList = arrayListOf()


        val browserIcons = arrayOf(
            R.drawable.ic_firefox_logo,
            R.drawable.chrome,
            R.drawable.microsoft,
            R.drawable.opera,
            R.drawable.brave,

            )

        val browserNames = arrayOf(
            "Firefox",
            "Chrome",
            "Edge",
            "Opera",
            "Brave",
        )

        val socialMediaIcons = arrayOf(
            R.drawable.facebook,
            R.drawable.instagram,
            R.drawable.snapchat,
            R.drawable.twitter,
            R.drawable.reddit,
            R.drawable.pinterest,

            )

        val socialMediaNames = arrayOf(
            "Facebook",
            "Instagram",
            "Snapchat",
            "Twitter",
            "Reddit",
            "Pinterest"
        )

        val messagingIcons = arrayOf(
            R.drawable.whatsapp,
            R.drawable.messenger,
            R.drawable.telegram,
            R.drawable.signal,


            )

        val messagingNames = arrayOf(
            "Whatsapp",
            "Messenger",
            "Telegram",
            "Signal",

            )



        val fileManagersIcons = arrayOf(
            R.drawable.solidexplorer,
            R.drawable.cx,



            )

        val fileManagersNames = arrayOf(
            "Solid Explorer",
            "Cx File Explorer",


            )

        val cloudIcons = arrayOf(
            R.drawable.drive,
            R.drawable.dropbox,


            )

        val cloudNames = arrayOf(
            "Drive",
            "DropBox",


        )

        for (i in browserIcons.indices) {
            val appBrowsers = AppCategory(browserIcons[i], browserNames[i])
            browserList.add(appBrowsers)
        }
        for (i in socialMediaIcons.indices) {
            val appBrowsers = AppCategory(socialMediaIcons[i], socialMediaNames[i])
            socialMediaList.add(appBrowsers)
        }
        for (i in messagingIcons.indices) {
            val appBrowsers = AppCategory(messagingIcons[i], messagingNames[i])
            messengersList.add(appBrowsers)
        }
        for (i in fileManagersIcons.indices) {
            val appBrowsers = AppCategory(fileManagersIcons[i], fileManagersNames[i])
            fileManagersList.add(appBrowsers)
        }
        for (i in cloudIcons.indices) {
            val appBrowsers = AppCategory(cloudIcons[i], cloudNames[i])
            cloudAppsList.add(appBrowsers)
        }


        val allAppsMap = mapOf<Int, ArrayList<AppCategory>>(
            0 to browserList,
            1 to socialMediaList,
            2 to messengersList,
            3 to fileManagersList,
            4 to cloudAppsList


        )

        val dataFromHome: Int = args.appType




        val recyclerView = binding.listOfApps

        recyclerView.adapter = allAppsMap[dataFromHome]?.let { ApplListRecyclerView(it) }
        recyclerView.layoutManager = LinearLayoutManager(context)





        appsViewModel.getApps().observe(viewLifecycleOwner) {
            //  binding.data = it.first().appName.toString()

        }


    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AllAppListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}