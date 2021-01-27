package com.sm.lecture3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentsAdapter (private val onItemClick: (item: Student) -> Unit): RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    private var list = listOf<Student>()

    fun submitList(newList: List<Student>?) {
        list = newList ?: listOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false), onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(view: View, private val onItemClick: (item: Student) -> Unit): RecyclerView.ViewHolder(view) {

        private val tvNameSurname = view.findViewById<TextView>(R.id.tv_name_surname)
        private val container = view

        fun bind(item: Student) {
            tvNameSurname.text = "${item.id} ${item.surname}"
            container.setOnClickListener {
                onItemClick.invoke(item)
            }
        }
    }
}