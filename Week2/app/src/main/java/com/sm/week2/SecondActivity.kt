package com.sm.week2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        intent.extras?.getParcelableArrayList<Student>(ARG_STUDENTS_LIST)?.let {

            val rvStudents = findViewById<RecyclerView>(R.id.rv_students)
            val studentsAdapter = StudentsAdapter()
            rvStudents.adapter = studentsAdapter

            studentsAdapter.submitList(it)

        }
    }
}