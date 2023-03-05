package com.ruslangrigoriev.poloskun_app.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruslangrigoriev.poloskun_app.R
import com.ruslangrigoriev.poloskun_app.ui.theme.Teal200

@Composable
fun TopBar(title: String, isRootScreen: Boolean, popOnClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 70.dp)
            )
        },
        backgroundColor = Color.White,
        contentColor = Teal200,
        elevation = 0.dp,
        navigationIcon = {
//                Box(
//                    modifier = Modifier
//                        .size(width = 70.dp, height = 50.dp),
//                    contentAlignment = Alignment.Center
//                ) {
//                    IconButton(
//                        onClick = { popOnClick() },
//                        modifier = Modifier
//                            .size(24.dp),
//                    ) {
//                        Image(
//                            painter = painterResource(id = R.drawable.ic_back),
//                            contentDescription = ""
//                        )
//                    }
//
//                }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar(stringResource(R.string.app_name), false) {}
}