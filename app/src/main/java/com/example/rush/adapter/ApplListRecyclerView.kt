package com.example.rush.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.rush.R
import com.example.rush.dataclasses.AppCategory
import com.example.rush.mvvm.Apps

class ApplListRecyclerView(
    private val appList: ArrayList<AppCategory>,
   // private val radioListener : RecyclerViewAdapter.OnItemClickListener
) : RecyclerView.Adapter<ApplListRecyclerView.AppListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppListViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.fragment_app_list, parent, false)
        return AppListViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppListViewHolder, position: Int) {
        holder.appName.text = appList[position].appTypeName
        holder.appIcon.setImageResource(appList[position].imageView)
    }

    override fun getItemCount(): Int {
        return appList.size
    }


    inner class AppListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var appName = itemView.findViewById<TextView>(R.id.app_name)
        var appIcon = itemView.findViewById<ImageView>(R.id.app_icon)

//        //val tickMark: RadioButton = itemView.findViewById<RadioButton>(R.id.radio_button)
//
//        init {
//            tickMark.setOnClickListener(this)
//        }

        override fun onClick(p0: View?) {
            val position = absoluteAdapterPosition

            if (position != RecyclerView.NO_POSITION) {
               // onRadioClickListener.onRadioClick()

            }

        }


    }

    interface onRadioClickListener{

        fun onRadioClick(position: Int)

    }


}

