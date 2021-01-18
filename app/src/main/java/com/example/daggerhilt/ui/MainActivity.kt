package com.example.daggerhilt.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerhilt.R
import com.example.daggerhilt.navigator.AppNavigator
import com.example.daggerhilt.navigator.Screen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appNavigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            appNavigator.navigateTo(Screen.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}
