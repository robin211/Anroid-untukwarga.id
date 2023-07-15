package com.untukwarga.id.core.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * @author Robin D. Putera
 * @date 07/07/2023
 */

@Composable
fun TestPage(text : String){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text24PxJakartaBold700(text = text)
    }
}

data class DummyContent(
    val id: Int,
    val region : String,
    val type: String,
    val imgUrl: String?,
    val videoUrl: String?,
    val title: String,
    val desc: String,
    val webUrl: String?
)

private fun createDummyContent(
    id: Int,
    type: String,
    title: String,
    desc: String,
    vidUrl: String,
    webUrl: String,
    region: String
): DummyContent {
    val imgId = 200 + id
    val imgUrl = "https://picsum.photos/$imgId"
    return DummyContent(
        id = id,
        type = type,
        imgUrl = imgUrl,
        videoUrl = vidUrl,
        title = title,
        desc = desc,
        webUrl = webUrl,
        region = region
    )
}

fun makeDummyContentList(): List<DummyContent> {
    val content1 = createDummyContent(
        id = 1,
        type = "video",
        title = "Lorem ipsum dolor sit amet",
        desc = "Desc 1",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        webUrl = "https://angrytools.com/android/pixelcalc/",
        region = "Desa/Kelurahan"
    )
    val content2 = createDummyContent(
        id = 2,
        type = "video",
        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
        desc = "Desc 2",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
        webUrl = "https://issuetracker.google.com/issues/182194894",
        region = "Kecamatan"
    )
    val content3 = createDummyContent(
        id = 3,
        type = "image",
        title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        desc = "Desc 3",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
        webUrl = "https://stackoverflow.com/questions/65610003/pass-parcelable-argument-with-compose-navigation/65619560#65619560",
        region = "Kabupaten"
    )
    val content4 = createDummyContent(
        id = 4,
        type = "video",
        title = "Ut enim ad minim veniam",
        desc = "Desc 4",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
        webUrl = "https://stackoverflow.com/questions/28190847/how-to-passing-list-in-bundle",
        region = "Provinsi"
    )
    val content5 = createDummyContent(
        id = 5,
        type = "video",
        title = "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat",
        desc = "Desc 1",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        webUrl = "https://www.baeldung.com/gson-list",
        region = "Desa/Kelurahan"
    )
    val content6 = createDummyContent(
        id = 6,
        type = "video",
        title = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur",
        desc = "Desc 2",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
        webUrl = "https://www.google.com",
        region = "Kecamatan"
    )
    val content7 = createDummyContent(
        id = 7,
        type = "image",
        title = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
        desc = "Desc 3",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
        webUrl = "https://www.google.com",
        region = "Kabupaten"
    )
    val content8 = createDummyContent(
        id = 8,
        type = "video",
        title = "Section 1.10.32 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC",
        desc = "Desc 4",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
        webUrl = "https://www.google.com",
        region = "Provinsi"
    )
    val content9 = createDummyContent(
        id = 9,
        type = "video",
        title = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo",
        desc = "Desc 1",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
        webUrl = "https://www.google.com",
        region = "Desa/Kelurahan"
    )
    val content10 = createDummyContent(
        id = 10,
        type = "video",
        title = "Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit",
        desc = "Desc 2",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
        webUrl = "https://www.google.com",
        region = "Kecamatan"
    )
    val content11 = createDummyContent(
        id = 11,
        type = "video",
        title = "sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt",
        desc = "Desc 3",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
        webUrl = "https://www.google.com",
        region = "Kabupaten"
    )
    val content12 = createDummyContent(
        id = 12,
        type = "image",
        title = "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem",
        desc = "Desc 4",
        vidUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
        webUrl = "https://www.google.com",
        region = "Provinsi"
    )
    return listOf(
        content1, content2, content3, content4,
        content5, content6, content7, content8,
        content9, content10, content11, content12,
    )
//        .shuffled()
}