package com.sm.hw4.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sm.hw4.data.User
import com.sm.hw4.databinding.ItemUserBinding

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private var list = listOf<User>()

    fun submitList(newList: List<User>?) {
        list = newList ?: listOf()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: User) {
            binding.tvName.text = item.name
            binding.tvWins.text = "Wins: ${item.wins}"
            binding.tvLoses.text = "Loses: ${item.loses}"
        }
    }
}