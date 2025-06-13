package com.example.pizza_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza_app.R
import com.example.pizza_app.ui.theme.CustomizePizzaTextColor
import com.example.pizza_app.ui.theme.SFProFont
import com.example.pizza_app.ui.theme.SelectedIngredientColor

@Composable
fun IngredientSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            "CUSTOMIZE YOUR PIZZA",
            fontFamily = SFProFont,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = CustomizePizzaTextColor,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        LazyRow(
            modifier = Modifier.padding(top = 10.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            item {
                SizedIngredientBox(painter = painterResource(R.drawable.basil_8))
            }
            item {
                SizedIngredientBox(painter = painterResource(R.drawable.onion_3))
            }
            item {
                SizedIngredientBox(painter = painterResource(R.drawable.broccoli_3))
            }
            item {
                SizedIngredientBox(painter = painterResource(R.drawable.mushroom_3))
            }
            item {
                SizedIngredientBox(painter = painterResource(R.drawable.sausage_3))
            }
        }
    }
}

@Composable
fun SizedIngredientBox(
    painter: Painter
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .size(65.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(SelectedIngredientColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = "ingredient image",
            modifier = Modifier.size(40.dp)
        )
    }
}