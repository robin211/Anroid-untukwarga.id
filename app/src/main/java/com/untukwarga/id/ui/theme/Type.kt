package com.untukwarga.id.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.untukwarga.id.R

// Set of Material typography styles to start with
val Typography: Typography
    get() = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        h5 = TextStyle(
            fontFamily = JakartaFont,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        ),
        caption = TextStyle(
            fontFamily = JakartaFont,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp
        ),
        button = TextStyle(
            fontFamily = JakartaFont,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        ),
        subtitle2 = TextStyle(
            fontFamily = JakartaFont,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        ),
        /* Other default text styles to override
        button = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        ),
        caption = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
        */
    )

val JakartaFont = FontFamily(
    Font(R.font.plusjakartasans_light),
    Font(R.font.plusjakartasans_regular),
    Font(R.font.plusjakartasans_medium),
    Font(R.font.plusjakartasans_bold, FontWeight.Bold),
    Font(R.font.plusjakartasans_extrabold, FontWeight.ExtraBold)
)