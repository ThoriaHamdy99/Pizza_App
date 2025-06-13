package com.example.pizza_app.ui.model

enum class PizzaSize(
    val sizeAsFloat: Float,
    val price: Int
) {
    SMALL(0.5f, 20),
    MEDIUM(0.6f, 40),
    LARGE(0.65f, 60)
}