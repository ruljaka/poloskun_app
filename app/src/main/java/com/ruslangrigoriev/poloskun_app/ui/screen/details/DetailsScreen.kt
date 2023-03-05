package com.ruslangrigoriev.poloskun_app.ui.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruslangrigoriev.poloskun_app.R
import com.ruslangrigoriev.poloskun_app.ui.theme.Teal200

@Composable
fun DetailsScreen() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false)
                .background(Color.White)
        ) {
            Box(contentAlignment = Alignment.TopStart) {
                Image(
                    painter = painterResource(R.drawable.gel_beloe),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp)
                        .clip(RoundedCornerShape(bottomStart = 70.dp))
                )
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .size(width = 40.dp, height = 40.dp)
                        .shadow(
                            elevation = 4.dp,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .size(24.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = ""
                        )
                    }
                }
            }
            Text(
                text = "Гель белое",
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "350 руб.",
                    fontSize = 30.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    modifier = Modifier
                        //.fillMaxWidth()
                        .padding(start = 16.dp),
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {
                    IconButton(
                        modifier = Modifier
                            .size(30.dp),
                        onClick = {},
                        enabled = true,
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_plus),
                                contentDescription = "",
                            )
                        }
                    )
                    Text(
                        text = "01",
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        fontSize = 18.sp,
                        color = Teal200,
                        maxLines = 3
                    )
                    IconButton(
                        modifier = Modifier
                            .size(30.dp),
                        onClick = {},
                        enabled = true,
                        content = {
                            Image(
                                painter = painterResource(id = R.drawable.ic_minus),
                                contentDescription = ""
                            )
                        }
                    )
                }
            }
            Text(
                text = stringResource(R.string.product_details_texet),
                modifier = Modifier
                    .padding(16.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black,
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
                text = "Add to cart",
                maxLines = 1,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen()
}