package com.sm.hw3

import android.util.Log
import java.util.*


/*
* NOTE: This is just to mimic Repository pattern principle.
* It's NOT a good idea to use Kotlin-object as Repository,
* due to objects lifespan tied to your application.
* It will save its own reference and cannot be garbage collected
* until application is closed
* */

private const val MAX_STORE_SIZE = 5

object StudentsRepository {

    private var studentIdCounter = 0
        get() {
            field++
            return field
        }


    private val students = mutableListOf<Student>()
    private val deletedStudents = LinkedList<Student>()

    fun getStudents() = students

    fun addStudent(name: String?): Boolean {
        val student = Student(studentIdCounter, name)
        val contains = students.contains(student)
        if (!contains) {
            students.add(student)
            Log.d("List", "Insert: ${student.id} ${students}")
        }
        return contains
    }

    fun getStudent(id: Int): Student {
        return students.find { student -> student.id == id } ?: Student(id)
    }

    fun deleteStudent(student: Student): Boolean {
        if (students.remove(student)) {
            if (deletedStudents.size >= MAX_STORE_SIZE)
                deletedStudents.removeFirst()
            deletedStudents.add(student)
            Log.d("List", "Delete: ${student.id} ${students}")
            return true
        }
        return false
    }

    fun restoreStudent(): Boolean {
        if (deletedStudents.size > 0) {
            val restored = deletedStudents.removeLast()
            students.add(restored)
            Log.d("List", "Restore: ${restored.id} ${students}")
            return true
        }
        return false
    }


}