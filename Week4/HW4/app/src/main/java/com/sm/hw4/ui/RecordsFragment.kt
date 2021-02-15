package com.sm.hw4.ui

import android.os.Bundle
import android.view.View
import com.sm.hw4.data.UsersRepository
import com.sm.hw4.databinding.FragmentRecordsBinding
import com.sm.hw4.utils.BindingFragment

class RecordsFragment: BindingFragment<FragmentRecordsBinding>(FragmentRecordsBinding::inflate) {

    private val repository = UsersRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = UsersAdapter()
        binding.rv.adapter = adapter
        adapter.submitList(repository.users)
    }

}