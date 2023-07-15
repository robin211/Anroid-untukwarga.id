package com.untukwarga.id.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = OrangePrimary,
    primaryVariant = Purple700,
    secondary = OrangePrimary
)

private val LightColorPalette = lightColors(
    primary = OrangePrimary,
    primaryVariant = Purple700,
    secondary = OrangePrimary,
    background = GrayBackgroundLight

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun UntukwargaidTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    if (darkTheme){
        systemUiController.setSystemBarsColor(color = Color.Black, darkIcons = false)
    }else{
        systemUiController.setSystemBarsColor(color = Color.White, darkIcons = true)
    }

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}