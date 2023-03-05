package com.ruslangrigoriev.poloskun_app.ui.screen.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruslangrigoriev.poloskun_app.R
import com.ruslangrigoriev.poloskun_app.data.MockProductsSource
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenItem
import com.ruslangrigoriev.poloskun_app.ui.theme.Purple500
import com.ruslangrigoriev.poloskun_app.ui.theme.Teal200
import com.ruslangrigoriev.poloskun_app.ui.theme.textDescr
import com.ruslangrigoriev.poloskun_app.ui.widget.CartItem

@Composable
fun CartScreen() {
    val items = MockProductsSource.previewMock()
    Column(

    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            itemsIndexed(items) { index, product ->
                when (product) {
                    is HomeScreenItem.HomeScreenProductItem -> {
                        CartItem(
                            product = product,
                            index = index,
                            onItemClick = { },
                            onItemCheck = { _, _ -> (run {}) }
                        )
                        //Divider(color = Color.Black, thickness = 1.dp)
                    }
                    else -> {
                        //TODO
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Total:",
                modifier = Modifier,
                fontSize = 20.sp,
                color = textDescr,
                maxLines = 2,
                fontWeight = FontWeight.Bold
                //fontFamily = FontFamily.SansSerif
            )
            Text(
                text = "1500.00",
                modifier = Modifier,
                fontSize = 20.sp,
                color = textDescr,
                maxLines = 2,
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Teal200,
                contentColor = Color.White
            ),
            modifier =
            Modifier
                //.background(Teal200)
                //.height(56.dp)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_basket),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(24.dp)
            )
            Text(
                text = "Check out",
                maxLines = 1,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    CartScreen()
}