package com.example.daggerhilt.navigator

import androidx.fragment.app.FragmentActivity
import com.example.daggerhilt.R
import com.example.daggerhilt.ui.ButtonsFragment
import com.example.daggerhilt.ui.LogsFragment
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

/**
 * Navigator implementation.
 */
class AppNavigatorImpl @Inject constructor(
    @ActivityContext val activity: FragmentActivity
) : AppNavigator {

    override fun navigateTo(screen: Screen) {
        val fragment = when (screen) {
            Screen.BUTTONS -> ButtonsFragment()
            Screen.LOGS -> LogsFragment()
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }
}
