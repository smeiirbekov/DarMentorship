package com.sm.lecture5.data

import com.sm.lecture5.data.models.Task

class CacheDataSource: DataSource {

    private val tasks = mutableListOf<Task>()

    override suspend fun createTask(task: Task): State<Task> {
        tasks.add(task)
        return State.Success(task)
    }

    override suspend fun getTasks(): State<List<Task>> {
        if (tasks.isEmpty()) {
            return State.ServerError("Empty")
        }
        return State.Success(tasks)
    }

    override suspend fun clear() {
        tasks.clear()
    }


}