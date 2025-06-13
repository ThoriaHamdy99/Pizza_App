package com.example.pizza_app.ui.model

data class PizzaUiModel(
    val bread: PizzaBread,
    val size: PizzaSize = PizzaSize.SMALL,
    val ingredients: List<Ingredient> = emptyList(),
    val price: Int = PizzaSize.SMALL.price,
)

fun PizzaUiModel.calculatePrice(): Int {
    return this.size.price + this.ingredients.calculatePrice()
}

fun List<Ingredient>.calculatePrice(): Int {
    var price = 0
    this.forEach { ingredient ->
        price += ingredient.price
    }
    return price
}