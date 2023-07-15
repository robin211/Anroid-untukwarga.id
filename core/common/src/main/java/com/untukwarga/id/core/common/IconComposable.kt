package com.untukwarga.id.core.common

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */
@Composable
fun AppIcon(modifier: Modifier) {
    Image(
        ImageVector.vectorResource(id = R.drawable.icon),
        contentDescription = null,
        modifier = modifier
    )
}