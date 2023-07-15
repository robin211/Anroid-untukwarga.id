package com.untukwarga.id.feature.webview.ui.screen

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WebViewScreen(url : String){
    Scaffold(
//        topBar = { TopAppBar(title = { Text("WebView", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },
        content = { MyContent(url) }
    )
}

@Composable
fun MyContent(url : String){
    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}