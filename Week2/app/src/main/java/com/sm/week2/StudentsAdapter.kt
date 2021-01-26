package com.sm.week2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentsAdapter: RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    private var list = listOf<Student>()

    fun submitList(newList: List<Student>?) {
        list = newList ?: listOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val tvNameSurname = view.findViewById<TextView>(R.id.tv_name_surname)

        fun bind(item: Student) {
            tvNameSurname.text = "${item.name} ${item.surname}"
        }
    }
}