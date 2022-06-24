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
import com.example.rush.adapter.AppListRecyclerView

import com.example.rush.databinding.FragmentAllAppListBinding

import com.example.rush.mvvm.*


class AllAppListFragment : Fragment() {


    //Someday I will make a proper database, for now
    //hardcoding the heck out of it.. lol.....

    lateinit var binding: FragmentAllAppListBinding
    lateinit var appsViewModel: AppsViewModel
    private lateinit var browserList: ArrayList<Apps>
    private lateinit var socialMediaList: ArrayList<Apps>
    private lateinit var messengersList: ArrayList<Apps>
    private lateinit var fileManagersList: ArrayList<Apps>
    private lateinit var cloudAppsList: ArrayList<Apps>
    private lateinit var imagingAppsList: ArrayList<Apps>
    private lateinit var mediaAndStreamAppsList: ArrayList<Apps>
    private lateinit var paymentAppsList: ArrayList<Apps>
    private lateinit var shoppingAppsList: ArrayList<Apps>
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


        val AppsNames = arrayOf(
            "Browsers",
            "Social Media",
            "Messaging",
//            "Documents",
            "File Managers",
            "Cloud",
            "Imaging",
            "Media & Streaming",
            "Shopping",

            "More"


        )
        binding.data = AppsNames[dataFromHome].toString()

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
        val ImagingIcons = arrayOf(
            R.drawable.picsart,
            R.drawable.ic_icons8_snapseed,
            R.drawable.gallery


            )

        val ImagingNames = arrayOf(
            "Picsart",
            "Snapseed",
            "Simple Gallery"


            )

        val MediaIcons = arrayOf(
            R.drawable.netflix,
            R.drawable.amazon,
            R.drawable.vlc,



        )

        val MediaNames = arrayOf(
            "Netflix",
            "Amazon Prime Video",
            "Vlc Media Player"


        )
        val shoppingIcons = arrayOf(
            R.drawable.amazon,
            R.drawable.ic_flipkart,


            )

        val shoppingNames = arrayOf(
            "Amazon",
            "Flipkart",

        )

        for (i in browserIcons.indices) {
            val appBrowsers = Apps(appIcon =  browserIcons[i], appName = browserNames[i])
            browserList.add(appBrowsers)
        }
        for (i in socialMediaIcons.indices) {
            val appBrowsers = Apps(appIcon = socialMediaIcons[i], appName =  socialMediaNames[i])
            socialMediaList.add(appBrowsers)
        }
        for (i in messagingIcons.indices) {
            val appBrowsers = Apps(appIcon = messagingIcons[i], appName = messagingNames[i])
            messengersList.add(appBrowsers)
        }
        for (i in fileManagersIcons.indices) {
            val appBrowsers = Apps(appIcon = fileManagersIcons[i], appName = fileManagersNames[i])
            fileManagersList.add(appBrowsers)
        }
        for (i in cloudIcons.indices) {
            val appBrowsers = Apps(appIcon = cloudIcons[i], appName = cloudNames[i])
            cloudAppsList.add(appBrowsers)
        }
        for (i in ImagingIcons.indices) {
            val appBrowsers = Apps(appIcon =  ImagingIcons[i], appName =  ImagingNames[i])
            imagingAppsList.add(appBrowsers)
        }
        for (i in  MediaIcons.indices) {
            val appBrowsers = Apps(appIcon =  MediaIcons[i], appName =  MediaNames[i])
            mediaAndStreamAppsList.add(appBrowsers)
        }
        for (i in  shoppingIcons.indices) {
            val appBrowsers = Apps(appIcon = shoppingIcons[i], appName =  shoppingNames[i])
            shoppingAppsList.add(appBrowsers)
        }


        val allAppsMap = mapOf<Int, ArrayList<Apps>>(
            0 to browserList,
            1 to socialMediaList,
            2 to messengersList,
            3 to fileManagersList,
            4 to cloudAppsList,
            5 to imagingAppsList,
            6 to mediaAndStreamAppsList,
            7 to shoppingAppsList


        )

        val dataFromHome: Int = args.appType




        val recyclerView = binding.listOfApps

        recyclerView.adapter = allAppsMap[dataFromHome]?.let { AppListRecyclerView(it) }
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