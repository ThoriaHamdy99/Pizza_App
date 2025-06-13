package com.example.pizza_app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza_app.R
import com.example.pizza_app.ui.theme.FavouriteIconColor
import com.example.pizza_app.ui.theme.SFProFont
import com.example.pizza_app.ui.theme.TextColor

@Composable
fun CustomTopBar(
    modifier: Modifier = Modifier,
    leftIcon: Painter,
    rightIcon: Painter,
    title: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = leftIcon,
            contentDescription = "Arrow back icon",
            colorFilter = ColorFilter.tint(FavouriteIconColor),
            modifier = Modifier.size(25.dp),
            alignment = Alignment.TopStart
        )
        Text(
            text = title,
            fontFamily = SFProFont,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.weight(2f),
            textAlign = TextAlign.Center,
            color = TextColor
        )
        Image(
            painter = rightIcon,
            contentDescription = "Arrow back icon",
            modifier = Modifier.size(25.dp),
            colorFilter = ColorFilter.tint(FavouriteIconColor),
            alignment = Alignment.TopEnd
        )
    }
}

@Preview
@Composable
fun CustomTopBarPreview() {
    CustomTopBar(
        leftIcon = painterResource(R.drawable.arrow_back),
        rightIcon = painterResource(R.drawable.favourite_outlined),
        title = "Pizza"
    )
}