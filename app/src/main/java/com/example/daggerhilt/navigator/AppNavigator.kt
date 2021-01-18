package com.example.daggerhilt.navigator

/**
 * Available screens.
 */
sealed class Screen {
    object BUTTONS : Screen()
    object LOGS : Screen()
}

/**
 * Interfaces that defines an app navigator.
 */
interface AppNavigator {
    fun navigateTo(screen: Screen)
}
