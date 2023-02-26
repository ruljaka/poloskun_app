package com.ruslangrigoriev.poloskun_app.ui.screen.home

import androidx.compose.runtime.Immutable
import com.ruslangrigoriev.poloskun_app.data.base.UiState

@Immutable
data class HomeScreenState(
    val isLoading: Boolean,
    val isError: Boolean,
    val errorMessage: String,
    val data: List<HomeScreenItem>,
) : UiState {

    companion object {
        fun initial() = HomeScreenState(
            isLoading = true,
            isError = false,
            errorMessage = "",
            data = emptyList()
        )
    }

    override fun toString(): String {
        return "isLoading: $isLoading, isError: $isError, data.size: ${data.size}, errorMessage: $errorMessage"
    }
}