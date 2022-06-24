package com.example.rush.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rush.R
import com.example.rush.dataclasses.AppCategory
import com.example.rush.mvvm.Apps

class AppListRecyclerView(
    private val appList: ArrayList<Apps>,
   // private val selectedApps: SelectedApps


    ) : RecyclerView.Adapter<AppListRecyclerView.AppListViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppListViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.fragment_app_list, parent, false)
        return AppListViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppListViewHolder, position: Int) {
        holder.appName.text = appList[position].appName
        holder.appIcon.setImageResource(appList[position].appIcon)
    }

    override fun getItemCount(): Int {
        return appList.size
    }


    public class AppListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val appName: TextView = itemView.findViewById<TextView>(R.id.app_name)
        val appIcon: ImageView = itemView.findViewById<ImageView>(R.id.app_icon)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkbox)

    }


//    public class AppListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
//        View.OnClickListener {
//
//        var appName = itemView.findViewById<TextView>(R.id.app_name)
//        var appIcon = itemView.findViewById<ImageView>(R.id.app_icon)
//
//
////
////        override fun onClick(p0: View?) {
////            val position = absoluteAdapterPosition
////
////            if (position != RecyclerView.NO_POSITION) {
////               // onRadioClickListener.onRadioClick()
////
////            }
////
////        }
//
//
//    }

//    interface onRadioClickListener{
//
//        fun onRadioClick(position: Int)
//
//    }


}

public interface SelectedApps {
    fun onSelectedChange(arrayOfSelectedApps: ArrayList<AppCategory>) {

    }
}

