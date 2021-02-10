package com.sm.lecture5.api

import com.sm.lecture5.data.models.Task
import java.util.concurrent.Callable

interface LectureApi {

    // POST
    suspend fun createTask(taskTitle: String): Task?

    // GET
    suspend fun getTasks(): List<Task>?

    fun createTaskOldFashioned(taskTitle: String): Callable<Task>

}