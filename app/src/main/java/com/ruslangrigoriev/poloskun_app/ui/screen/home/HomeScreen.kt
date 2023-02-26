package com.ruslangrigoriev.poloskun_app.ui.screen.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenEvent.OnItemCheckedChanged
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenEvent.OpenDetailsScreen
import com.ruslangrigoriev.poloskun_app.ui.widget.ProductItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    Log.d("TAG", "$state")
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            state.isLoading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            state.isError -> ShowError(message = state.errorMessage)
            state.data.isNotEmpty() -> {
                ProductsList(
                    products = state.data,
                    onItemClick = { productId ->
                        viewModel.obtainEvent(OpenDetailsScreen(productId))
                    },
                    onItemCheck = { index, isChecked ->
                        viewModel.obtainEvent(OnItemCheckedChanged(index, isChecked))
                    }
                )
            }
        }
    }
}

@Composable
fun ProductsList(
    products: List<HomeScreenItem>,
    onItemClick: (Int) -> Unit,
    onItemCheck: (Int, Boolean) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(products) { index, product ->
            when (product) {
                is HomeScreenItem.HomeScreenProductItem -> {
                    ProductItem(
                        product = product,
                        index = index,
                        onItemClick = onItemClick,
                        onItemCheck = onItemCheck
                    )
                }
                else -> {
                    //TODO
                }
            }

        }
    }
}

@Composable
fun ShowError(message: String) {
    Text(
        text = message,
        color = MaterialTheme.colors.error,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
        //.align(Alignment.Center)
    )
}


