@file:Suppress("UNCHECKED_CAST")

package com.untukwarga.id.feature.serambi.ui.screen

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberImagePainter
import com.google.android.material.math.MathUtils
import com.google.gson.Gson
import com.untukwarga.id.core.common.*
import com.untukwarga.id.feature.serambi.ui.R
import kotlinx.coroutines.launch

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */

@Composable
fun SerambiScreen(navHostController: NavHostController) {
    Scaffold {
        Log.d("TAG", "$it")
        FillWithDUmmies(navHostController)
    }
}

@Composable
fun FillWithDUmmies(navHostController: NavHostController) {
    val dummy = makeDummyContentList()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        TopBarMain()
        ContentSection(dummy, navHostController)
    }
}

@Composable
fun TopBarMain() {
    val topBarColor = if (isSystemInDarkTheme()) Color.Black else Color.White
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(topBarColor)
            .padding(16.dp, 24.dp, 16.dp, 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppIcon(modifier = Modifier.size(37.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text14PxJakartaMedium600(
                text = "Untuk Warga",
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Image(
                imageVector = Icons.Default.AccountCircle,
                colorFilter = ColorFilter.tint(color = Color.LightGray),
                contentDescription = null,
                modifier = Modifier
                    .height(37.dp)
                    .fillMaxWidth(),
                alignment = Alignment.CenterEnd
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentSection(dummy: List<DummyContent>, navHostController: NavHostController) {
    val pageCount = Int.MAX_VALUE
    val pagerState = rememberPagerState(
        initialPage = pageCount / 2
    )

    var direction by remember { mutableStateOf(-1) }

    val fling = PagerDefaults.flingBehavior(
        state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(0),
        snapAnimationSpec = spring(stiffness = Spring.StiffnessMedium),
    )

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            pageCount = pageCount,
            state = pagerState,
            userScrollEnabled = true,
            beyondBoundsPageCount = 3,
            flingBehavior = fling,
            contentPadding = PaddingValues(horizontal = 16.dp),
            pageSpacing = 16.dp,
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDrag = { change, dragAmount ->
                            val (x, y) = dragAmount
                            if (Math.abs(x) > Math.abs(y)) {
                                when {
                                    x > 0 -> {
                                        //right
                                        direction = 0
                                    }
                                    x < 0 -> {
                                        // left
                                        direction = 1
                                    }
                                }
                            } else {
                                when {
                                    y > 0 -> {
                                        // down
                                        direction = 2
                                    }
                                    y < 0 -> {
                                        // up
                                        direction = 3
                                    }
                                }
                            }
                        },
                        onDragEnd = {
                            when (direction) {
                                0 -> {
                                    Log.d("DRAGGED", "Dragged Right")
                                }
                                1 -> {
                                    Log.d("DRAGGED", "Dragged Left")
                                }
                                2 -> {
                                    Log.d("DRAGGED", "Dragged Down")
                                }
                                3 -> {
                                    Log.d("DRAGGED", "Dragged Up")
                                    val bundle = Bundle()
                                    val itemString = Gson().toJson(dummy)
                                    bundle.putString(
                                        "items",
                                        itemString
                                    )
                                    navHostController.navigate(
                                        route = NavigationConstant.serambiReelsScreenRoute,
                                        args = bundle
                                    )
                                }
                            }
                        }
                    )
                }
        ) {
            val index = it % (dummy.size)
//            val index = it
            val coroutineScope = rememberCoroutineScope()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp, 16.dp, 0.dp, 40.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .clickable {
                        coroutineScope.launch {
                            // Call scroll to on pagerState
                            pagerState.animateScrollToPage(
                                page = it + 1,
                                animationSpec = tween(
                                    durationMillis = 100,
                                    easing = FastOutSlowInEasing
                                )
                            )
                        }
                    }
            ) {
                val pageOffset = pagerState.calculateCurrentOffsetForPage(it)
                AsyncImage(
                    model = dummy[index].imgUrl,
                    contentDescription = null,
                    error = painterResource(id = com.untukwarga.id.core.common.R.drawable.exclamationround),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            val scale = MathUtils.lerp(1.75f, 1f, pageOffset)
                            scaleX = scale
                            scaleY = scale
                        }
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0x44000000))
                )
                InfoHolder(dummy[index])

            }
        }

        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            text = "Geser keatas untuk melihat detail berita",
            color = Color.LightGray,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontSize = 12.sp
            )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
fun PagerState.calculateCurrentOffsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffsetFraction
}

@Composable
fun InfoHolder(content: DummyContent) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp, 0.dp, 8.dp, 16.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = content.region,
                color = Color.White,
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text16PxJakartaBold700WhiteShadowed(text = content.title)
            Spacer(modifier = Modifier.height(4.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text12PxJakartaMedium600WhiteShadowed(text = "Rizqi Adi Surya")
                Spacer(modifier = Modifier.width(8.dp))
                Text12PxJakartaNormal500GrayShadowed(text = "2 menit lalu")
            }
        }
    }
}


