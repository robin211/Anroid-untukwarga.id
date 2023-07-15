package com.untukwarga.id.core.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

/**
 * @author Robin D. Putera
 * @date 06/07/2023
 */
@Composable
fun ButtonLogin(
    text : String,
    isActive : Boolean,
    modifier: Modifier,
    isLoading : MutableState<Boolean>
){
    val color = if (isActive) MaterialTheme.colors.primary else Color(0xFFBDBDBD)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
//        if (!isLoading.value){
//            Text(
//                text = text,
//                color = Color.White,
//                fontWeight = FontWeight.Bold,
//            )
//        }else{
//            CircularProgressIndicator(color = Color.White)
//
//        }

    }
}

@Composable
fun ButtonBack(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(Color(0xFFF2F2F2))
            .clickable {
                navHostController.popBackStack()
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.back ),
            contentDescription = "Back",
            colorFilter = ColorFilter.tint(Color.Black)
        )
    }
}