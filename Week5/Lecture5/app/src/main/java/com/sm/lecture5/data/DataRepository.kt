package com.sm.lecture5.data

import com.sm.lecture5.api.LectureApi
import com.sm.lecture5.api.MockApi
import com.sm.lecture5.data.models.Task


// Single Source of Truth (SSOT)
class DataRepository{

    private val remoteDataSource: DataSource = RemoteDataSource()
    private val cacheDataSource: DataSource = CacheDataSource()
    private val localDataSource: DataSource = CacheDataSource()

    suspend fun createTask(title: String): State<Task> {

        return State.ServerError("asd")
    }

    // Local source, -> Wait until remote ready and then new emit of remote source
    suspend fun getTasks(): State<List<Task>> {
        val localRes = cacheDataSource.getTasks()
        return if (localRes is State.Success) {
            localRes
        } else {
            val remoteRes = remoteDataSource.getTasks()
            if (remoteRes is State.Success) {
                cacheDataSource.clear()
                remoteRes.result?.forEach {
                    cacheDataSource.createTask(it)
                }
            }
            remoteRes
        }
    }

}