package com.example.daggerhilt.data

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject

interface LoggerDataSource {
    fun addLog(message: String)
    fun getAllLogs(callback: (List<Log>) -> Unit)
    fun deleteAllLogs()
}

class LoggerDataSourceImpl @Inject constructor(
    private val logDao: LogDao
) : LoggerDataSource {

    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)
    private val mainThreadHandler by lazy {
        Handler(Looper.getMainLooper())
    }


    override fun addLog(message: String) {
        executorService.execute {
            logDao.insertAll(
                Log(
                    message = message,
                    timeStamp = System.currentTimeMillis()
                )
            )
        }
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
        executorService.execute {
            val logs = logDao.getAll()
            mainThreadHandler.post { callback(logs) }
        }
    }

    override fun deleteAllLogs() {
        executorService.execute {
            logDao.nukeTable()
        }
    }

}
