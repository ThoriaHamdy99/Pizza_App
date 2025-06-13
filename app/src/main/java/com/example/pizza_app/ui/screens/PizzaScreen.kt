package com.example.pizza_app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizza_app.R
import com.example.pizza_app.ui.components.CustomScaffold
import com.example.pizza_app.ui.components.CustomTopBar
import com.example.pizza_app.ui.theme.PizzaScreenColor
import com.example.pizza_app.ui.theme.SFProFont
import com.example.pizza_app.ui.theme.TextColor
import com.example.pizza_app.ui.viewmodel.PizzaViewModel

@Composable
fun PizzaScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel by remember { mutableStateOf( PizzaViewModel()) }
    val uiState = viewModel.uiState.collectAsState().value

    CustomScaffold(
        modifier = modifier,
        topBar = {
            CustomTopBar(
                modifier = Modifier.padding(top = 45.dp),
                leftIcon = painterResource(R.drawable.arrow_back),
                rightIcon = painterResource(R.drawable.favourite_outlined),
                title = "Pizza"
            )
        }
    ) {
        Column(
            modifier = Modifier
                .background(PizzaScreenColor)
        ) {
            PizzaPlateSection(
                modifier = Modifier.padding(20.dp),
                plateImage = painterResource(R.drawable.plate),
                pizzaUiModels = uiState.pizzaUiModels,
                updateCurrentPizza = viewModel::updateCurrentPizza
            )
            Text(
                text = "$${uiState.currentPizza.price}",
                fontFamily = SFProFont,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 16.dp, end = 16.dp),
                textAlign = TextAlign.Center,
                color = TextColor
            )
            PizzaSizeSection(
                modifier = Modifier.padding(top = 20.dp, start = 16.dp, end = 16.dp),
                selectedSize = uiState.currentPizza.size,
                pizzaUiModel = uiState.currentPizza,
                updatePizzaSize = viewModel::updatePizzaSize
            )

            IngredientSection(modifier = Modifier.padding(vertical = 20.dp))

            AddToCart(
                modifier = Modifier
                    .padding(40.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}