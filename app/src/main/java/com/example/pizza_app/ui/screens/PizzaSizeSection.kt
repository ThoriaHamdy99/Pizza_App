package com.example.pizza_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza_app.ui.model.PizzaSize
import com.example.pizza_app.ui.model.PizzaUiModel
import com.example.pizza_app.ui.theme.SFProFont
import com.example.pizza_app.ui.theme.TextColor

@Composable
fun PizzaSizeSection(
    modifier: Modifier,
    selectedSize: PizzaSize,
    pizzaUiModel: PizzaUiModel,
    updatePizzaSize: (PizzaUiModel, PizzaSize) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        SizedBox("S", pizzaUiModel, updatePizzaSize)
        SizedBox("M", pizzaUiModel, updatePizzaSize)
        SizedBox("L", pizzaUiModel, updatePizzaSize)
    }
}

@Composable
fun SizedBox(
    text: String,
    pizzaUiModel: PizzaUiModel,
    updatePizzaSize: (PizzaUiModel, PizzaSize) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .size(40.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Color.White)
            .clickable {
                updatePizzaSize(
                    pizzaUiModel, text.getPizzaSize()
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = SFProFont,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = TextColor
        )
    }
}

fun String.getPizzaSize(): PizzaSize {
    return when (this) {
        "S" -> PizzaSize.SMALL
        "M" -> PizzaSize.MEDIUAM
        "L" -> PizzaSize.LARGE
        else -> {
            PizzaSize.SMALL
        }
    }
}