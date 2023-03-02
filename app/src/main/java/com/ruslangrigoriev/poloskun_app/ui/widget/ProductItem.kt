package com.ruslangrigoriev.poloskun_app.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruslangrigoriev.poloskun_app.R
import com.ruslangrigoriev.poloskun_app.ui.screen.home.HomeScreenItem
import com.ruslangrigoriev.poloskun_app.ui.theme.Purple500
import com.ruslangrigoriev.poloskun_app.ui.theme.Teal200
import com.ruslangrigoriev.poloskun_app.ui.theme.textDescr
import com.ruslangrigoriev.poloskun_app.ui.theme.textMain
import com.ruslangrigoriev.poloskun_app.utils.format

@Composable
fun ProductItem(
    product: HomeScreenItem.HomeScreenProductItem,
    index: Int,
    onItemClick: (Int) -> Unit,
    onItemCheck: (Int, Boolean) -> Unit
) {
    val count = remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .width(200.dp)
            //.fillMaxWidth()
            .background(Color.White)
            .clickable { onItemClick(product.id) }

    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(product.image),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )

            Text(
                text = product.name,
                modifier = Modifier
                    .requiredHeight(60.dp)
                    .padding(top = 8.dp),
                fontSize = 14.sp,
                color = textDescr,
                maxLines = 3
            )
            Row(
                modifier = Modifier
                    //.background(Color.Green)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${product.retailPrice.format(0)} руб.",
                    modifier = Modifier
                    //.background(Color.Cyan)
                    //.padding(top = 8.dp)
                    ,
                    color = textMain,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            Button(
                onClick = { onItemCheck(index, !product.isChecked) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (product.isChecked) Purple500 else Teal200,
                    contentColor = Color.White
                ),
                modifier =
                Modifier
                    //.background(Teal200)
                    //.height(56.dp)
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
                    text = if (product.isChecked) "Удалить" else "В корзину",
                    maxLines = 1,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    val product = HomeScreenItem.HomeScreenProductItem(
        id = 1,
        article = "1132П",
        name = "Гель для стирки универсальный",
        quantity = 20,
        purchaseCost = 155.25,
        retailPrice = 320.0,
        isBottling = true,
        image = R.drawable.gel_universal,
        isChecked = false
    )
    ProductItem(product, 1, {}, { _, _ -> (run {}) })
}
