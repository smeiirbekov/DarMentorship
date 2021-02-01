package com.sm.hw3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentsAdapter (
    private val onClick: (item: Student) -> Unit,
    private val onDelete: (item: Student, position: Int, adapter: StudentsAdapter) -> Unit,
): RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    private var list = listOf<Student>()

    fun submitList(newList: List<Student>?) {
        list = newList ?: listOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val tvName = view.findViewById<TextView>(R.id.tv_id_name)
        private val btnDelete = view.findViewById<Button>(R.id.btn_delete)
        private val container = view

        fun bind(position: Int, item: Student) {
            tvName.text = "Student: ${item.id} - ${item.name}"
            btnDelete.setOnClickListener {
                onDelete.invoke(item, position, this@StudentsAdapter)
            }
            container.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }
}