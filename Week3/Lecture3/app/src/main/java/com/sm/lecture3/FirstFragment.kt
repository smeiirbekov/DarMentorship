package com.sm.lecture3

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sm.lecture3.databinding.FragmentFirstBinding

class FirstFragment: Fragment(R.layout.fragment_first) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFirstBinding.bind(view)

        binding.run {

            findNavController().navigate(R.id.action_global_thirdFragment)

            val adapter = StudentsAdapter {
                // You cannot pass more than 1mb data through bundles. Passing more throws exception
                // All data passed through bundles are stored in disk upon destruction, and retrieved when recreated
                findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(it.id))
            }

            rvStudents.adapter = adapter

            val list = mutableListOf<Student>()

            for (i in 0..20) {
                list.add(Student(i))
            }

            adapter.submitList(list)

            var counter = 20
            btnAddStudent.setOnClickListener {
                list.add(Student(counter))
                counter++
                adapter.notifyDataSetChanged()
            }
        }
    }

}