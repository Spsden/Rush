package com.example.rush.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rush.HomeFragment
import com.example.rush.R
import com.example.rush.dataclasses.AppCategory

class RecyclerViewAdapter(
    private val appCategoryList: ArrayList<AppCategory>,

) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.browsersgrid,parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentCard = appCategoryList[position]
        holder.appCategoryImage.setImageResource(currentCard.imageView)
        holder.appCategoryName.text = currentCard.appTypeName

    }

    override fun getItemCount(): Int {
        return appCategoryList.size
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val appCategoryImage : ImageView = itemView.findViewById(R.id.app_category_thumb)

        val appCategoryName : TextView = itemView.findViewById(R.id.app_category_name)



    }
}