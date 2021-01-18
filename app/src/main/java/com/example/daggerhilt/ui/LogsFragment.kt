package com.example.daggerhilt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggerhilt.R
import com.example.daggerhilt.data.LoggerDataSource
import com.example.daggerhilt.util.DateFormatter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_logs.*
import javax.inject.Inject

@AndroidEntryPoint
class LogsFragment : Fragment() {

    @Inject
    lateinit var dateFormatter: DateFormatter

    @Inject
    lateinit var loggerDataSource: LoggerDataSource

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvLogs.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        loggerDataSource.getAllLogs { logs ->
            rvLogs.adapter = LogsAdapter(
                logs = logs,
                dateFormatter = dateFormatter
            )
        }

    }
}
