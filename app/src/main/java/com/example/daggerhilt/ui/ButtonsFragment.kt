package com.example.daggerhilt.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggerhilt.R
import com.example.daggerhilt.data.LoggerDataSource
import com.example.daggerhilt.navigator.AppNavigator
import com.example.daggerhilt.navigator.Screen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_buttons.*
import javax.inject.Inject

@AndroidEntryPoint
class ButtonsFragment : Fragment() {

    @Inject
    lateinit var appNavigator: AppNavigator

    @Inject
    lateinit var loggerDataSource: LoggerDataSource

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        button1.setOnClickListener {
            loggerDataSource.addLog("Interaction with 'Button 1'")
        }

        button2.setOnClickListener {
            loggerDataSource.addLog("Interaction with 'Button 2'")
        }

        button3.setOnClickListener {
            loggerDataSource.addLog("Interaction with 'Button 3'")
        }

        allLogs.setOnClickListener {
            appNavigator.navigateTo(Screen.LOGS)
        }

        deleteLogs.setOnClickListener {
            loggerDataSource.deleteAllLogs()
        }
    }
}
