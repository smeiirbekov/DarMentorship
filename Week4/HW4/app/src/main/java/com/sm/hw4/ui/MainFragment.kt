package com.sm.hw4.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.sm.hw4.databinding.FragmentMainBinding
import com.sm.hw4.utils.BindingFragment

class MainFragment: BindingFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNewGame.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainToNewUsers())
        }
        binding.btnRecords.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainToRecords())
        }
    }

}