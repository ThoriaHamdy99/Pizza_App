package com.example.pizza_app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizza_app.R
import com.example.pizza_app.ui.model.PizzaBread
import com.example.pizza_app.ui.model.PizzaUiModel
import com.example.pizza_app.ui.theme.PizzaScreenColor

@Composable
fun PizzaPlateSection(
    modifier: Modifier = Modifier,
    pizzaUiModels: List<PizzaUiModel>,
    plateImage: Painter,
    updateCurrentPizza: (PizzaUiModel) -> Unit
) {
    val pageCount = pizzaUiModels.size
    val pagerState = rememberPagerState(initialPage = 0) { pageCount }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = PizzaScreenColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = plateImage,
            contentDescription = "Plate image",
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        LaunchedEffect(pagerState) {
            snapshotFlow { pagerState.currentPage }.collect { page ->
                updateCurrentPizza(pizzaUiModels[page])
            }
        }

        HorizontalPager(
            state = pagerState,
        ) { page ->
            PageContent(page, pizzaUiModels[page])
        }
    }
}

@Composable
fun PageContent(
    page: Int,
    pizzaUiModel: PizzaUiModel,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(pizzaUiModel.bread.breadResId),
            contentDescription = "Plate image",
            modifier = Modifier.fillMaxWidth(pizzaUiModel.size.sizeAsFloat)
        )
    }
}

@Preview
@Composable
fun PizzaPlateSectionPreview() {
    PizzaPlateSection(
        modifier = Modifier.padding(20.dp),
        plateImage = painterResource(R.drawable.plate),
        pizzaUiModels = listOf(
            PizzaUiModel(bread = PizzaBread.BREAD_1),
            PizzaUiModel(bread = PizzaBread.BREAD_2),
            PizzaUiModel(bread = PizzaBread.BREAD_3),
            PizzaUiModel(bread = PizzaBread.BREAD_4),
            PizzaUiModel(bread = PizzaBread.BREAD_5)
        ),
        updateCurrentPizza = {}
    )
}