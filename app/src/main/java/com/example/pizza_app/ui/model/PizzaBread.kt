package com.example.pizza_app.ui.model

import androidx.annotation.DrawableRes
import com.example.pizza_app.R

enum class PizzaBread(
    @DrawableRes val breadResId: Int,
) {
    BREAD_1(R.drawable.bread_1),
    BREAD_2(R.drawable.bread_2),
    BREAD_3(R.drawable.bread_3),
    BREAD_4(R.drawable.bread_4),
    BREAD_5(R.drawable.bread_5),
}