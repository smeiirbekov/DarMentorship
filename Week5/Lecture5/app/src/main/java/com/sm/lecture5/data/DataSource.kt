package com.sm.lecture5.data

import com.sm.lecture5.data.models.Task

interface DataSource {

    suspend fun createTask(task: Task): State<Task>

    suspend fun getTasks(): State<List<Task>>

    suspend fun clear()
}