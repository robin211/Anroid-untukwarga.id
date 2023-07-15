package com.untukwarga.id.feature.login.ui.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.untukwarga.id.core.common.*
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

/**
 * @author Robin D. Putera
 * @date 05/07/2023
 */

@Composable
fun LoginScreen(navHostController : NavHostController){
    val bgColor = if (!isSystemInDarkTheme()) Color.White else Color.Black
    val txtUsername = remember{ mutableStateOf("") }
    val txtPassword = remember{ mutableStateOf("") }
    val btnActive = remember{ mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(bgColor)
        .padding(horizontal = 16.dp)
        .verticalScroll(rememberScrollState())
    ){
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(Color.LightGray)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text24PxJakartaBold700(text = "Login")
        Spacer(modifier = Modifier.height(4.dp))
        Text12PxPoppinsNormal400Grey(text = "Silakan login untuk menggunakan fitur dari UntukWarga.id")
        Spacer(modifier = Modifier.height(24.dp))
        Text14PxJakartaMedium600(text = "No. Whatsapp")
        Spacer(modifier = Modifier.height(8.dp))
        TextFieldCustom(
            "Masukkan No. Whatsapp",
            KeyboardOptions(keyboardType = KeyboardType.Number),
            txtUsername
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text14PxJakartaMedium600(text = "Password")
        Spacer(modifier = Modifier.height(8.dp))
        TextFieldPassword(
            "Masukkan Password",
            txtPassword
        )
        Spacer(modifier = Modifier.height(48.dp))
        if (txtPassword.value != "" && txtUsername.value != ""){
            if (!btnActive.value) btnActive.value = true
        }else{
            if (btnActive.value) btnActive.value = false
        }

        var isLoading = remember { mutableStateOf(false) }
        if (btnActive.value){
            ButtonLogin(
                text = "Login Sekarang",
                isActive = true,
                modifier = Modifier.clickable {
                    isLoading.value = !isLoading.value
                    navHostController.navigate(NavigationConstant.mainPageScreenRoute){
                        popUpTo(navHostController.graph.id) {
                            inclusive = true
                        }
                    }
                },
                isLoading = isLoading
            )
        }else{
            isLoading.value = false
            ButtonLogin(
                text = "Login Sekarang",
                isActive = false,
                modifier = Modifier,
                isLoading = isLoading
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.fillMaxWidth()){
            Row(modifier = Modifier.align(Alignment.Center)) {
                Text12PxPoppinsNormal400Grey(text = "Belum punya akun?")
                Spacer(modifier = Modifier.width(8.dp))
                Text12PxPoppinsMedium400Primary(
                    text = "Daftar sekarang",
                    modifier = Modifier.clickable {
                        navHostController.navigate(NavigationConstant.registerScreenRoute)
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}