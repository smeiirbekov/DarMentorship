package com.sm.lecture5.api

import com.sm.lecture5.data.models.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.util.concurrent.Callable
import kotlin.random.Random

class MockApi: LectureApi {

    override suspend fun createTask(taskTitle: String): Task? {
        return withContext(Dispatchers.IO) {
            delay(2000)
            val id = Random.nextInt(0, 100)
            if (id>=50) {
                Task(id, "Name #$id")
            } else {
                null
            }
        }
    }

    override suspend fun getTasks(): List<Task>? {
        return withContext(Dispatchers.IO) {
            delay(2000)
            val list = mutableListOf<Task>()
            for (i in 0..10) {
                val id = Random.nextInt(0, 100)
                list.add(Task(id, "Name #$id"))
            }
            return@withContext list
        }
    }

    override fun createTaskOldFashioned(taskTitle: String): Callable<Task> {
        TODO("Not yet implemented")
    }

}