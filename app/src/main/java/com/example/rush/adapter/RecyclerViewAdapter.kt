package com.example.rush.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rush.R
import com.example.rush.dataclasses.AppCategory

class RecyclerViewAdapter(
    private val appCategoryList: ArrayList<AppCategory>,
    private val listener: OnItemClickListener,
  //  private val isList : Boolean


    ) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

      //  if (isList){
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.browsersgrid, parent, false)
            return ViewHolder(itemView)
//
//        } else {
//
//            val itemView =
//                LayoutInflater.from(parent.context).inflate(R.layout.browserslist, parent, false)
//            return ViewHolder(itemView)
//
//        }


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCard = appCategoryList[position]
        holder.appCategoryImage.setImageResource(currentCard.imageView)
        holder.appCategoryName.text = currentCard.appTypeName

    }

    override fun getItemCount(): Int {
        return appCategoryList.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        val appCategoryImage: ImageView = itemView.findViewById(R.id.app_category_thumb)

        val appCategoryName: TextView = itemView.findViewById(R.id.app_category_name)

        init {

            itemView.setOnClickListener(this)

        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                listener.onCardClick(position)
            }

        }


    }

    interface OnItemClickListener{
        fun onCardClick(position: Int)
    }
}