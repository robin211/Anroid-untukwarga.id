package com.untukwarga.id.feature.mainpage.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.untukwarga.id.core.common.DummyContent
import com.untukwarga.id.core.common.NavigationConstant
import com.untukwarga.id.core.common.TestPage
import com.untukwarga.id.feature.selasar.ui.screen.SelasarScreen
import com.untukwarga.id.feature.serambi.ui.screen.SerambiScreen
import com.untukwarga.id.feature.serambireels.ui.screen.SerambiReelsScreen
import com.untukwarga.id.feature.webview.ui.screen.WebViewScreen
import java.lang.reflect.Type

/**
 * @author Robin D. Putera
 * @date 08/07/2023
 */

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun BottomNavGraph (navHostController: NavHostController, bottomBarState : MutableState<Boolean>){
    NavHost(navController = navHostController, startDestination = NavigationConstant.serambiScreenRoute){
        composable(route = NavigationConstant.serambiScreenRoute ){
//            val viewModel = hiltViewModel<ContentViewModel>()
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            SerambiScreen(navHostController)
        }

        composable(route = NavigationConstant.selasarScreenRoute ){
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            SelasarScreen(navHostController = navHostController)
        }

        composable(route = NavigationConstant.pustakaScreenRoute ){
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            TestPage("Pustaka")
        }

        composable(route = NavigationConstant.dakuScreenRoute ){
            LaunchedEffect(Unit) {
                bottomBarState.value = true
            }
            TestPage("Daku")
        }

        composable(route = NavigationConstant.serambiReelsScreenRoute ){
            LaunchedEffect(Unit) {
                bottomBarState.value = false
            }
            val listOfDummyContent: Type = object : TypeToken<ArrayList<DummyContent?>?>() {}.type
            val itemString = it.arguments?.getString("items")
            val items : List<DummyContent> = Gson().fromJson(itemString, listOfDummyContent)
            SerambiReelsScreen(items = items, navHostController = navHostController)
        }

        composable(route = NavigationConstant.webViewScreenRoute ){
            LaunchedEffect(Unit) {
                bottomBarState.value = false
            }
            val url = it.arguments?.getString("webUrl")
            WebViewScreen(url = url!!)
        }


//        composable(route = "detail/{url}"){
//            val id = it.arguments?.getString("url")
//            LaunchedEffect(Unit) {
//                bottomBarState.value = false
//            }
//            WebViewScreen(id!!)
//        }


    }
}

data class listDummyContent(
    var items : List<DummyContent>
)