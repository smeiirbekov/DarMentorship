package com.sm.lecture3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.sm.lecture3.databinding.FragmentSecondBinding

class SecondFragment: Fragment(R.layout.fragment_second) {

    private val args: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSecondBinding.bind(view)

        Log.d("Second", "Args: ${args.id}")

    }
}