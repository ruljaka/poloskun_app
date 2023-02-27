package com.ruslangrigoriev.poloskun_app.ui.navigation

import com.ruslangrigoriev.poloskun_app.R

interface NavTarget {
    val destination: String
}

sealed class Graph(override val destination: String) : NavTarget {
    object RootGraph : Graph("root_graph")
    object AuthGraph : Graph("auth_graph")
    object MainGraph : Graph("main_graph")
    object HomeGraph : Graph("home_graph")
    object SettingsGraph : Graph("settings_graph")
    object CartGraph : Graph("cart_graph")
}

sealed class Screen(
    override val destination: String,
    val title: String,
    val icon: Int = 0
) : NavTarget {

    //AuthGraph
    object Login : Screen(destination = "LOGIN", title = "Login")
    object SignUp : Screen(destination = "SIGN_UP", title = "SignUp")
    object Forgot : Screen(destination = "FORGOT", title = "Forgot Password")

    //HomeGraph
    object Home : Screen(destination = "HOME", title = "Home", icon = R.drawable.ic_home)
    object Details : Screen(destination = "DETAILS", title = "Details")

    //SettingsGraph
    object Settings :
        Screen(destination = "SETTINGS", title = "Settings", icon = R.drawable.ic_settings)

    //CartGraph
    object Cart :
        Screen(destination = "CART", title = "Cart", icon = R.drawable.ic_cart)
}



