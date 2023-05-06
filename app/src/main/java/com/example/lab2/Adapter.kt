package com.example.lab2

import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val fragment: FirstFragment, private val listofMovies: ArrayList<Movie_DataClass>,
    private val listener: Listener): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView. ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_director)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i:Int) {
        val movie = listofMovies[i]
        viewHolder.itemView.setOnClickListener{
            listener.onClick(i)
        }
        Glide.with(fragment)
            .load(listofMovies.get(i).URL).fitCenter().into(viewHolder.itemImage)
        viewHolder.itemDetail.text = movie.detail
        viewHolder.itemTitle.text = movie.titles
    }

    override fun getItemCount(): Int {
        return listofMovies.size
    }

    interface Listener{
        fun onClick(itemView: Int)
    }
}