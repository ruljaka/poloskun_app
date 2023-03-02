package com.ruslangrigoriev.poloskun_app.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruslangrigoriev.poloskun_app.R
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenItem
import com.ruslangrigoriev.poloskun_app.ui.theme.Teal200
import com.ruslangrigoriev.poloskun_app.ui.theme.textDescr

@Composable
fun CartItem(
    product: HomeScreenItem.HomeScreenProductItem,
    index: Int,
    onItemClick: (Int) -> Unit,
    onItemCheck: (Int, Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(height = 100.dp, width = 0.dp)
            .background(Color.White)
            .clickable { onItemClick(product.id) }
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
        ) {
            Image(
                painter = painterResource(product.image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Blue)
                    .clip(RoundedCornerShape(10.dp))
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(start = 16.dp)
                    .background(Color.Red)
            ) {
                Text(
                    text = product.name,
                    modifier = Modifier
                        .background(Color.Green)
                        //.fillMaxWidth()
                        ,
                    fontSize = 14.sp,
                    color = textDescr,
                    maxLines = 2
                )
                Text(
                    text = product.retailPrice.toString(),
                    modifier = Modifier
                        .background(Color.Blue),
                    fontSize = 16.sp,
                    color = Teal200,
                    maxLines = 3
                )
                Text(
                    text = product.retailPrice.toString(),
                    modifier = Modifier
                        .background(Color.Blue),
                    fontSize = 16.sp,
                    color = Teal200,
                    maxLines = 3
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(24.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartItemPreview() {
    val product = HomeScreenItem.HomeScreenProductItem(
        id = 1,
        article = "1132П",
        name = "Гель для стирки универсальный Гель для стирки универсальный",
        quantity = 20,
        purchaseCost = 155.25,
        retailPrice = 320.0,
        isBottling = true,
        image = R.drawable.gel_universal,
        isChecked = false
    )
    CartItem(product, 1, {}, { _, _ -> (run {}) })
}
