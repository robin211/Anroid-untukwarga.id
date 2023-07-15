package com.untukwarga.id.core.common

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */

object NavigationConstant{

    //    Tier 1
    const val loginNestedRoute = "login_nested_route"
    const val loginScreenRoute = "login_screen_route"

    const val registerNestedRoute = "register_nested_route"
    const val registerScreenRoute = "register_screen_route"

    const val forgotPasswordNestedRoute = "forgot_password_nested_route"
    const val forgotPasswordScreenRoute = "forgot_password_screen_route"

    const val mainPageNestedRoute = "main_page_nested_route"
    const val mainPageScreenRoute = "main_page_screen_route"

    const val sosPageNestedRoute = "sos_nested_route"
    const val sosPageScreenRoute = "sos_screen_route"


    //    Tier 2
    const val serambiScreenRoute = "serambi_screen_route"
    const val selasarScreenRoute = "selasar_screen_route"
    const val pustakaScreenRoute = "pustaka_screen_route"
    const val dakuScreenRoute = "daku_screen_route"


    //    Tier 3
    const val contentDetailScreenRoute = "content_detail_screen_route"
    const val serambiReelsScreenRoute = "serambi_reels_screen_route"
    const val webViewScreenRoute = "webview_screen_route"
}

object LocationConstant{
    const val locationProvince = 1
    const val locationKabupatenKota = 2
    const val locationKecamatan = 3
    const val locationKelurahan = 4
}