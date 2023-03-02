package com.ruslangrigoriev.poloskun_app.ui.screen.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruslangrigoriev.poloskun_app.data.MockProductsSource
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenEvent
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenItem
import com.ruslangrigoriev.poloskun_app.ui.screen.home.ProductsList
import com.ruslangrigoriev.poloskun_app.ui.widget.CartItem
import com.ruslangrigoriev.poloskun_app.ui.widget.ProductItem

@Composable
fun SettingsScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .wrapContentSize(Alignment.Center)
//    ) {
//        Text(
//            text = "Settings View",
//            fontWeight = FontWeight.ExtraLight,
//            color = Color.Black,
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            textAlign = TextAlign.Center,
//            fontSize = 25.sp
//        )
//    }
    val items = MockProductsSource.previewMock()
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        //horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(items) { index, product ->
            when (product) {
                is HomeScreenItem.HomeScreenProductItem -> {
                    CartItem(
                        product = product,
                        index = index,
                        onItemClick = {  },
                        onItemCheck = { _, _ -> (run {}) }
                    )
                }
                else -> {
                    //TODO
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}
