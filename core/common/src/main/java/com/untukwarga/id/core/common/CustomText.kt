package com.untukwarga.id.core.common

import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author Robin D. Putera
 * @date 06/07/2023
 */

@Composable
fun Text24PxJakartaBold700(text:String){
    Text(
        text = text,
        fontFamily = JakartaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    )
}

@Composable
fun Text14PxJakartaMedium600(text:String, modifier: Modifier? = Modifier){
    Text(
        text = text,
        fontFamily = JakartaFont,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        modifier = modifier ?: Modifier,
        color = if (isSystemInDarkTheme()) Color.White else Color(0xFF4F4F4F)
    )
}

@Composable
fun Text14PxJakartaBold700(text:String){
    Text(
        text = text,
        fontFamily = JakartaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = if (isSystemInDarkTheme()) Color.White else Color(0xFF4F4F4F)
    )
}

@Composable
fun Text10PxJakartaNormal400Grey(text:String){
    Text(
        text = text,
        fontFamily = JakartaFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color(0xFF828282)
    )
}

@Composable
fun Text16PxJakartaBold700WhiteShadowed(text:String){
    Text(
        text = text,
        fontFamily = JakartaFont,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        style = TextStyle(
            color = Color.White,
            shadow = Shadow(
                color = Color.DarkGray,
                offset = Offset(1f, 1f),
                blurRadius = 2f
            )
        ),

    )
}

@Composable
fun Text12PxJakartaMedium600WhiteShadowed(text:String){
    Text(
        text = text,
        fontFamily = JakartaFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        style = TextStyle(
            color = Color.White,
            shadow = Shadow(
                color = Color.DarkGray,
                offset = Offset(1f, 1f),
                blurRadius = 2f
            )
        ),

        )
}

@Composable
fun Text12PxJakartaNormal500GrayShadowed(text:String){
    Text(
        text = text,
        fontFamily = JakartaFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        style = TextStyle(
            color = Color.LightGray,
            shadow = Shadow(
                color = Color.DarkGray,
                offset = Offset(1f, 1f),
                blurRadius = 2f
            )
        ),

        )
}

@Composable
fun Text12PxPoppinsNormal400Grey(text:String){
    Text(
        text = text,
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color(0xFF828282)
    )
}

@Composable
fun Text12PxPoppinsNormal400Orange(text:String){
    Text(
        text = text,
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color(0xFFF2994A)
    )
}

@Composable
fun Text10PxPoppinsBold700Primary(text:String){
    Text(
        text = text,
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = MaterialTheme.colors.primary
    )
}

@Composable
fun Text12PxPoppinsMedium400Primary(text:String, modifier: Modifier){
    Text(
        text = text,
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = MaterialTheme.colors.primary,
        modifier = modifier
    )
}

@Composable
fun Text12PxPoppinsNormal400LightGrey(text:String){
    Text(
        text = text,
        fontFamily = PoppinsFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color(0xFFE0E0E0)
    )
}

@Composable
fun makeToast(text : String){
    Toast.makeText(LocalContext.current, text, Toast.LENGTH_SHORT).show()
}

val JakartaFont = FontFamily(
    Font(R.font.plusjakartasans_light, FontWeight.Light),
    Font(R.font.plusjakartasans_regular, FontWeight.Normal),
    Font(R.font.plusjakartasans_medium, FontWeight.Medium),
    Font(R.font.plusjakartasans_bold, FontWeight.Bold),
    Font(R.font.plusjakartasans_extrabold, FontWeight.ExtraBold)
)

val PoppinsFont = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold)
)