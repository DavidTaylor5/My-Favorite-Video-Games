package com.example.topthirty.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.topthirty.R


val RobotoSlab = FontFamily(
    Font(R.font.robotoslab_regular),
    Font(R.font.robotoslab_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
      fontFamily = RobotoSlab,
      fontWeight = FontWeight.Bold,
      fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = RobotoSlab,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        fontFamily = RobotoSlab,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

)