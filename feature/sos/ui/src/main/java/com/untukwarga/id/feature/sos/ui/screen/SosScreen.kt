package com.untukwarga.id.feature.sos.ui.screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.untukwarga.id.core.common.*

/**
 * @author Robin D. Putera
 * @date 09/07/2023
 */

@Composable
fun SosScreen(navHostController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            SosHeader(navHostController = navHostController)
            SosContent()
        }
    }
}

@Composable
fun SosContent() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(16.dp))
        CustomInfoOrangeExclamation(
            text = "Anda akan terhubung ke nomor terkait jika memilih salah satu opsi dari pilihan di bawah.",
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(16.dp))
        sosItemTest(LocalContext.current)
    }
}

@Composable
fun SosHeader(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = CenterVertically) {
            ButtonBack(navHostController = navHostController)
            Spacer(modifier = Modifier.width(16.dp))
            Text14PxJakartaMedium600(text = "Panggilan Darurat")
        }

    }
}

@Composable
fun sosItemTest(context : Context){
    Box(modifier = Modifier.fillMaxWidth()){
        Row(Modifier.fillMaxWidth()) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.Gray),
                modifier = Modifier
                    .size(48.dp)
                    .weight(1.5f)
                    .align(CenterVertically)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(7f)) {
                Text10PxPoppinsBold700Primary(text = "Kelurahan")
                Text14PxJakartaBold700(text = "Pemadam Kebakaran")
                Text10PxJakartaNormal400Grey(text = "Nomor telepon digunakan untuk keperluan pemadaman api atau hal lainnya")
            }
            Image(
                imageVector = Icons.Default.Call,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.Gray),
                modifier = Modifier
                    .size(40.dp)
                    .weight(1.5f)
                    .align(CenterVertically)
                    .clickable {
                        val u = Uri.parse("tel:" + "123")
                        val i = Intent(Intent.ACTION_DIAL, u)
                        try {
                            context.startActivity(i)
                        } catch (s: SecurityException) {
                            Toast
                                .makeText(context, "An error occurred", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
            )

        }
    }
}
