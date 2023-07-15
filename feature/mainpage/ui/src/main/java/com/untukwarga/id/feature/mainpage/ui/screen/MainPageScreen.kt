package com.untukwarga.id.feature.mainpage.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.untukwarga.id.core.common.NavigationConstant
import com.untukwarga.id.feature.mainpage.ui.navigation.BottomNavGraph
import com.untukwarga.id.feature.mainpage.ui.R

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */
@Composable
fun MainPageScreen(mainNavController : NavHostController) {
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    Box(modifier = Modifier.fillMaxSize()){
        Scaffold(
            bottomBar = {
                BottomBar(
                    navHostController = navController,
                    bottomBarState = bottomBarState,
                    mainNavController = mainNavController
                )
            }
        ) {
            Box(modifier = Modifier.padding(it)) {
                BottomNavGraph(navHostController = navController, bottomBarState)
            }

        }
    }
}

@Composable
fun BottomBar(navHostController: NavHostController, bottomBarState: MutableState<Boolean>, mainNavController: NavHostController) {
    val screens = listOf(
        MainPage.Serambi,
        MainPage.Selasar,
        MainPage.Blank,
        MainPage.Pustaka,
        MainPage.Daku,
    )

    AnimatedVisibility(
        visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }, animationSpec = keyframes {
            this.durationMillis = 300
        }),
        exit = slideOutVertically(targetOffsetY = { it }, animationSpec = keyframes {
            this.durationMillis = 300
        }),
        content = {
            BottomNavigation(
                backgroundColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
            ) {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                screens.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            if (item.iconId != null) {
                                Icon(
                                    imageVector = ImageVector.vectorResource(id = item.iconId),
                                    contentDescription = item.title
                                )
                            }
                        },
                        label = {
                            if (item.title != null) {
                                Text(text = item.title, modifier = Modifier.padding(top = 8.dp))
                            }
                        },
                        selected = currentRoute == item.route,
                        unselectedContentColor = Color.LightGray,
                        selectedContentColor = MaterialTheme.colors.primary,
                        onClick = {
                            if (item.route != null){
                                navHostController.navigate(item.route) {
                                    popUpTo(navHostController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
            Box(modifier = Modifier.fillMaxWidth()){
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.sos),
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                        .padding(top = 8.dp)
                        .align(Alignment.Center)
                        .clickable {
                            mainNavController.navigate(NavigationConstant.sosPageScreenRoute)
                        }
                )
            }

        }
    )

}