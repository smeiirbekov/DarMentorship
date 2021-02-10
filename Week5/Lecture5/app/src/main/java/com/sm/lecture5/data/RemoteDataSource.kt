package com.sm.lecture5.data

import com.sm.lecture5.api.LectureApi
import com.sm.lecture5.api.MockApi
import com.sm.lecture5.data.models.Task

class RemoteDataSource: DataSource {

    private var service: LectureApi = MockApi()

    override suspend fun createTask(task: Task): State<Task> {

        val res = service.createTask(task.title)

        return if (res!=null) {
            State.Success(res)
        } else {
            State.ServerError("Something went wrong")
        }
    }

    override suspend fun getTasks(): State<List<Task>> {

        val res = service.getTasks()
        return if (res!=null) {
            State.Success(res)
        } else {
            State.ServerError("Something went wrong")
        }
    }

    override suspend fun clear() {
        // service.clear()
    }
}