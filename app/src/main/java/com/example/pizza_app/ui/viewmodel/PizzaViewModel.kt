package com.example.pizza_app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pizza_app.ui.model.Ingredient
import com.example.pizza_app.ui.model.PizzaBread
import com.example.pizza_app.ui.model.PizzaSize
import com.example.pizza_app.ui.model.PizzaUiModel
import com.example.pizza_app.ui.model.PizzaUiState
import com.example.pizza_app.ui.model.calculatePrice
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        PizzaUiState(
            pizzaUiModels = emptyList(),
            currentPizza = PizzaUiModel(bread = PizzaBread.BREAD_1)
        )
    )
    val uiState: StateFlow<PizzaUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = PizzaUiState(
            pizzaUiModels = listOf(
                PizzaUiModel(bread = PizzaBread.BREAD_1),
                PizzaUiModel(bread = PizzaBread.BREAD_2),
                PizzaUiModel(bread = PizzaBread.BREAD_3),
                PizzaUiModel(bread = PizzaBread.BREAD_4),
                PizzaUiModel(bread = PizzaBread.BREAD_5)
            ),
            currentPizza = PizzaUiModel(bread = PizzaBread.BREAD_1)
        )

    }

    fun updatePizzaSize(pizza: PizzaUiModel, size: PizzaSize) {
        _uiState.update { pizzaUiState ->
            var currentIndex = 0
            pizzaUiState.copy(
                pizzaUiModels = pizzaUiState.pizzaUiModels.mapIndexed { index, currentPizza ->
                    if (currentPizza == pizza) {
                        val updatedPizza = currentPizza.copy(size = size)
                        currentIndex = index
                        updatedPizza.copy(price = updatedPizza.calculatePrice())
                    } else currentPizza
                },
                currentPizza = pizzaUiState.pizzaUiModels.get(currentIndex)
            )
        }
    }

    fun updateCurrentPizza(pizza: PizzaUiModel) {
        _uiState.update { pizzaUiState ->
            pizzaUiState.copy(
                currentPizza = pizza
            )
        }
    }

    fun addIngredient(pizza: PizzaUiModel, ingredient: Ingredient) {
        _uiState.update { pizzaUiState ->
            var currentIndex = 0
            pizzaUiState.copy(
                pizzaUiModels = pizzaUiState.pizzaUiModels.mapIndexed { index, currentPizza ->
                    if (currentPizza == pizza) {
                        currentIndex = index
                        currentPizza.ingredients.toMutableList().add(
                            ingredient
                        )
                        currentPizza.copy(price = currentPizza.calculatePrice())
                    } else currentPizza
                },
                currentPizza = pizzaUiState.pizzaUiModels.get(currentIndex)
            )
        }
    }

    fun removeIngredient(pizza: PizzaUiModel, ingredient: Ingredient) {
        _uiState.update { pizzaUiState ->
            var currentIndex = 0
            pizzaUiState.copy(
                pizzaUiModels = pizzaUiState.pizzaUiModels.mapIndexed { index, currentPizza ->
                    if (currentPizza == pizza) {
                        currentIndex = index
                        currentPizza.ingredients.toMutableList().remove(
                            ingredient
                        )
                        currentPizza.copy(price = currentPizza.calculatePrice())
                    } else currentPizza
                },
                currentPizza = pizzaUiState.pizzaUiModels.get(currentIndex)
            )
        }
    }
}