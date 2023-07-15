package com.untukwarga.id.feature.selasar.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.untukwarga.id.core.common.VerticalScrollableContent
import com.untukwarga.id.core.common.makeDummyContentList

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */

@Composable
fun SelasarScreen(navHostController: NavHostController){
    val items = makeDummyContentList()
    VerticalScrollableContent(items = items, navHostController = navHostController)
}