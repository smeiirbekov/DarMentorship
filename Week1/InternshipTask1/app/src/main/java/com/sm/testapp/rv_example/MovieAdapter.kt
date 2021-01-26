package com.sm.testapp.rv_example

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sm.testapp.R

class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var dataSet: ArrayList<Movie> = ArrayList()

    fun submitList(newList: ArrayList<Movie>){
        Log.d("Adapter", "list: ${newList}")
        dataSet = newList
        notifyDataSetChanged()
    }

    fun appendList(newList: ArrayList<Movie>) {
        dataSet.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = dataSet[position].name
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tvTitle: TextView = view.findViewById(R.id.tv_title)

    }

}