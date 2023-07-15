package com.untukwarga.id.feature.serambireels.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.untukwarga.id.core.common.DummyContent
import com.untukwarga.id.core.common.VerticalScrollableContent

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */

@Composable
fun SerambiReelsScreen( items : List<DummyContent>, navHostController: NavHostController,){
    VerticalScrollableContent(items = items, navHostController = navHostController)
}