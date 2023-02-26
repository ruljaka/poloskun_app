package com.ruslangrigoriev.poloskun_app.ui

sealed class Routes(val route: String) {
    object Login : Routes("Login")
}