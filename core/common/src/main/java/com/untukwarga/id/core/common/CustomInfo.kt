package com.untukwarga.id.core.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */

@Composable
fun CustomInfoOrangeExclamation(text: String, modifier: Modifier) {
    Box(
        modifier = modifier
            .border(width = 2.dp, color = MaterialTheme.colors.primary, shape = RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0x22FF6C45))
            .padding(16.dp),
    ){
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.exclamationround),
                contentDescription = null,
                modifier = Modifier.align(CenterVertically).size(32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text12PxPoppinsNormal400Orange(text = text)
        }
    }
}