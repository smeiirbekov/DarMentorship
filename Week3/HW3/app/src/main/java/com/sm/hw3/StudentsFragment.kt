package com.sm.hw3

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sm.hw3.databinding.FragmentStudentsBinding

class StudentsFragment: BindingFragment<FragmentStudentsBinding>(FragmentStudentsBinding::inflate) {

    private val repository = StudentsRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.run {

            val adapter = StudentsAdapter(
                onClick = { student ->
                    findNavController().navigate(StudentsFragmentDirections.actionStudentsFragmentToStudentDetailsFragment(student.id))
                          },
                onDelete = { student, position, adapter ->
                    if (repository.deleteStudent(student)) {
                        adapter.notifyItemRemoved(position)
                        adapter.notifyItemRangeChanged(position, adapter.itemCount - position)
                    }
                })

            rvStudents.adapter = adapter
            adapter.submitList(repository.getStudents())

            btnAddStudent.setOnClickListener {
                if (repository.addStudent(etName.text.toString())) {
                    Toast.makeText(context, "Student already in the list!", Toast.LENGTH_SHORT).show()
                } else {
                    adapter.notifyItemInserted(repository.getStudents().size-1)
                }
            }

            btnRestore.setOnClickListener {
                if (repository.restoreStudent()) {
                    adapter.notifyItemInserted(repository.getStudents().size)
                }
            }
        }
    }

}