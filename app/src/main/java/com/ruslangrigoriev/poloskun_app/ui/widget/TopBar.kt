package com.ruslangrigoriev.poloskun_app.ui.widget

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ruslangrigoriev.poloskun_app.R
import com.ruslangrigoriev.poloskun_app.ui.theme.Teal200

@Composable
fun TopBar(title: String) {
    TopAppBar(
        title = { Text(text = title, fontSize = 18.sp) },
        backgroundColor = Color.White,
        contentColor = Teal200
    )
}


@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar(stringResource(R.string.app_name))
}