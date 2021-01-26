package com.sm.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf

const val ARG_STUDENTS_LIST = "students_list"

class MainActivity : AppCompatActivity() {

    private val students = mutableSetOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvStudentCount = findViewById<TextView>(R.id.tv_students_count)
        val etName = findViewById<EditText>(R.id.et_name)
        val etSurname = findViewById<EditText>(R.id.et_surname)
        val btnAddStudent = findViewById<Button>(R.id.btn_add_student)
        val btnNavigateToSecondPage = findViewById<Button>(R.id.btn_navigate)


        btnAddStudent.setOnClickListener {

            if (etName.text.isNullOrEmpty() || etSurname.text.isNullOrEmpty()) {
                Toast.makeText(this@MainActivity, "Text fields cannot be empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val student = Student(etName.text.toString(), etSurname.text.toString())
            if (students.contains(student)) {
                Toast.makeText(this@MainActivity, "Student already in the list!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                students.add(student)
                tvStudentCount.text = "Students count: ${students.size}"
            }

        }

        btnNavigateToSecondPage.setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java).apply {
                putExtras(bundleOf(Pair(ARG_STUDENTS_LIST, students.toList())))
            })
        }
    }
}