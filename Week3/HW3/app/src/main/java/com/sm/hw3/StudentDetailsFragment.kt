package com.sm.hw3

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.sm.hw3.databinding.FragmentStudentDetailsBinding
import com.sm.hw3.databinding.FragmentStudentsBinding

class StudentDetailsFragment: BindingFragment<FragmentStudentDetailsBinding>(FragmentStudentDetailsBinding::inflate) {

    private val repository = StudentsRepository
    private val args: StudentDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.run {

            val student = repository.getStudent(args.id)

            tvId.text = "ID: ${student.id}"
            tvName.text = "Name: ${student.name ?: ""}"
            tvSurname.text = "Surname: ${student.surname ?: ""}"
            tvGrade.text = "Grade: ${student.grade ?: ""}"
        }
    }

}