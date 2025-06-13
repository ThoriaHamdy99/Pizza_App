package com.example.pizza_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza_app.R
import com.example.pizza_app.ui.theme.AddToCartColor
import com.example.pizza_app.ui.theme.SFProFont

@Composable
fun AddToCart(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(AddToCartColor)
            .padding(horizontal = 30.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.cart_filled),
            contentDescription = "add to cart image",
            modifier = Modifier.size(25.dp)
        )
        Text(
            text = "Add to cart",
            fontFamily = SFProFont,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}