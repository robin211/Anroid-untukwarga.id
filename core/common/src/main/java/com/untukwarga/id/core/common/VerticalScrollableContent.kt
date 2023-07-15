package com.untukwarga.id.core.common

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView
import kotlinx.coroutines.delay
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import kotlin.time.Duration.Companion.seconds

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalScrollableContent(items : List<DummyContent>, navHostController: NavHostController){
    val pagerState = rememberPagerState()

    val fling = PagerDefaults.flingBehavior(
        state = pagerState,
        pagerSnapDistance = PagerSnapDistance.atMost(0),
        snapAnimationSpec = spring(stiffness = Spring.StiffnessHigh),
    )

    Box(modifier = Modifier.fillMaxSize()) {
        VerticalPager(
            pageCount = items.size,
            state = pagerState,
            flingBehavior = fling,
            modifier = Modifier.fillMaxSize(),
            beyondBoundsPageCount = 3
        ) { currentPage ->
            if (items[currentPage].type == "image") {
                ImageBasedContent(content = items[currentPage])
            } else if (items[currentPage].type == "video") {
                VideoBasedContent(
                    content = items[currentPage],
                    currentPage,
                    pagerState,
                    navHostController = navHostController
                )
            }
        }
    }
}

@Composable
fun ImageBasedContent(content: DummyContent) {
    AsyncImage(
        model = content.imgUrl,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VideoBasedContent(
    content: DummyContent,
    index: Int,
    pagerState: PagerState,
    navHostController: NavHostController
) {
    val context = LocalContext.current
    var isBuffering by remember { mutableStateOf(true) }
    val isPaused = remember { mutableStateOf(false) }
    val currentValue = remember { mutableStateOf(0F) }
    var isPlaying by remember { mutableStateOf(false) }

    val playerEventListener = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            super.onPlaybackStateChanged(playbackState)
            isBuffering = playbackState == ExoPlayer.STATE_BUFFERING
        }

        override fun onIsPlayingChanged(isPlaying_: Boolean) {
            isPlaying = isPlaying_
        }
    }

    val mPlayer = remember {
        ExoPlayer.Builder(context)
            .build()
            .also { exoPlayer ->
                val mediaItem = MediaItem.Builder()
                    .setUri(content.videoUrl)
                    .build()
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.repeatMode = Player.REPEAT_MODE_ONE
                exoPlayer.playWhenReady = false
                exoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING
                exoPlayer.addListener(playerEventListener)
                exoPlayer.prepare()
            }
    }

    if (isPlaying){
        LaunchedEffect(Unit) {
            while(true) {
                currentValue.value = 1f * mPlayer.currentPosition / mPlayer.contentDuration
                delay(1.seconds / 30)
            }
        }
    }

    DisposableEffect(
        AndroidView(
            factory = {
                StyledPlayerView(context).apply {
                    useController = false
                    setShowBuffering(StyledPlayerView.SHOW_BUFFERING_NEVER)
                    layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                    player = mPlayer
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT
                }
            },
            modifier = Modifier.clickable {
                if (mPlayer.isPlaying) {
                    mPlayer.pause()
                    isPaused.value = true
                } else {
                    mPlayer.play()
                    isPaused.value = false
                }
            })
    ) {
        onDispose {
            mPlayer.release()
        }
    }

    if (index == pagerState.currentPage) {
        mPlayer.play()
    } else {
        mPlayer.pause()
    }

    val lifecycleEvent = rememberLifecycleEvent()
    LaunchedEffect(lifecycleEvent) {
        Log.d("LIFECYCLEXX", "$lifecycleEvent")

        when (lifecycleEvent) {
            Lifecycle.Event.ON_PAUSE -> {
                mPlayer.pause()
            }
            Lifecycle.Event.ON_STOP -> {
                mPlayer.release()
            }
            Lifecycle.Event.ON_DESTROY -> {
                mPlayer.release()
            }
            Lifecycle.Event.ON_CREATE -> {

            }
            Lifecycle.Event.ON_START -> {

            }
            Lifecycle.Event.ON_RESUME -> {

            }
            Lifecycle.Event.ON_ANY -> {

            }
        }
    }

    if (isBuffering) {
        ShowBuffering()
    }

    if (isPaused.value) {
        ShowPlayButton(mPlayer = mPlayer, isPaused)
    }

    InfoHolder(content, navHostController = navHostController, currentValue)
}

@Composable
fun InfoHolder(info: DummyContent, navHostController: NavHostController, currentValue : MutableState<Float>) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomStart
    ) {
        Column(Modifier.fillMaxWidth()) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            color = Color.Red,
                            shape = CircleShape
                        )
                        .padding(end = 8.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Rizqi Adi Surya",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontSize = 13.sp,
                        shadow = Shadow(
                            color = Color.DarkGray,
                            offset = Offset(1.0f, 1.0f),
                            blurRadius = 2f
                        )
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "2 menit lalu", color = Color.LightGray,
                    style = TextStyle(
                        fontSize = 13.sp,
                        shadow = Shadow(
                            color = Color.DarkGray,
                            offset = Offset(1.0f, 1.0f),
                            blurRadius = 2f
                        )
                    )
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                style = TextStyle(
                    fontSize = 12.sp,
                    shadow = Shadow(
                        color = Color.DarkGray,
                        offset = Offset(1.0f, 1.0f),
                        blurRadius = 2f
                    )
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0x22FFFFFF))
                    .clickable {
                        if (info.webUrl != null){
                            val bundle = Bundle()
                            val url = info.webUrl
                            bundle.putString(
                                "webUrl",
                                url
                            )
                            navHostController.navigate(
                                route = NavigationConstant.webViewScreenRoute,
                                args = bundle
                            )
                        }
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Detail Berita",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        fontSize = 14.sp,
                        shadow = Shadow(
                            color = Color.DarkGray,
                            offset = Offset(1.0f, 1.0f),
                            blurRadius = 2f
                        )
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp),
                progress = currentValue.value
            )
        }
    }
}

@Composable
fun ShowBuffering() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun ShowPlayButton(mPlayer: ExoPlayer, isPause: MutableState<Boolean>) {
    mPlayer.pause()
    Box(modifier = Modifier
        .fillMaxSize()
        .clickable {
            mPlayer.play()
            isPause.value = false
        }) {
        Image(
            imageVector = Icons.Default.PlayArrow,
            colorFilter = ColorFilter.tint(color = Color.White),
            contentDescription = null,
            modifier = Modifier
                .align(
                    Alignment.Center
                )
                .size(80.dp),

            )
    }
}

@Composable
fun rememberLifecycleEvent(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current): Lifecycle.Event {
    var state by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            state = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    return state
}

