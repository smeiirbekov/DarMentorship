package com.sm.hw4.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.sm.hw4.databinding.FragmentNewUsersBinding
import com.sm.hw4.utils.BindingFragment

class NewUsersFragment: BindingFragment<FragmentNewUsersBinding>(FragmentNewUsersBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            btnContinue.setOnClickListener {
                if (etUserX.text.isNotEmpty() && etUserO.text.isNotEmpty() && etUserX.text.toString()!=etUserO.text.toString()) {
                    findNavController().navigate(
                        NewUsersFragmentDirections.actionNewUsersToGame(etUserX.text.toString(), etUserO.text.toString()))
                }
            }
        }
    }

}