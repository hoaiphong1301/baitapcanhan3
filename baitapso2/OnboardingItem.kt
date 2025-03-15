package com.example.baitapso2


import androidx.annotation.DrawableRes

data class OnboardingItem(
    val imageRes: Int, // Không cần annotation @DrawableRes nếu lỗi xảy ra
    val title: String,
    val description: String
)