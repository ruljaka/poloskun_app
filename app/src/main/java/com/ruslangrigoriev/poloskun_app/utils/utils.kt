package com.ruslangrigoriev.poloskun_app.utils

import com.ruslangrigoriev.poloskun_app.domain.Resource
import com.ruslangrigoriev.poloskun_app.ui.navigation.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException

fun getTitleByRoute(route: String): String {
    return when  {
        route.contains(Screen.Login.destination) -> Screen.Login.title
        route.contains(Screen.SignUp.destination) -> Screen.SignUp.title
        route.contains(Screen.Forgot.destination) -> Screen.Forgot.title
        route.contains(Screen.Home.destination) -> Screen.Home.title
        route.contains(Screen.Details.destination) -> Screen.Details.title
        route.contains(Screen.Settings.destination) -> Screen.Settings.title
        else -> ("Route not found")
    }
}

fun <T> getResponse(request: suspend () -> T): Flow<Resource<T>> {
    return flow {
        try {
            emit(Resource.Loading())
            val data = request.invoke()
            emit(Resource.Success(data))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }.flowOn(Dispatchers.IO)
}

fun Double.format(digits: Int) = "%.${digits}f".format(this)