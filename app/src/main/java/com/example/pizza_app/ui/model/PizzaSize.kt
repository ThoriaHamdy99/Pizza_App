package com.example.pizza_app.ui.model

enum class PizzaSize(
    val sizeAsFloat: Float,
    val price: Int
) {
    SMALL(0.5f, 20),
    MEDIUAM(0.6f, 40),
    LARGE(0.7f, 60)
}