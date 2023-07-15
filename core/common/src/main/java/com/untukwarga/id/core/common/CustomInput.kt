package com.untukwarga.id.core.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

/**
 * @author Robin D. Putera
 * @date 06/07/2023
 */

@Composable
fun TextFieldCustom(
    placeHolder: String,
    keyboardOptions: KeyboardOptions,
    txt: MutableState<String>
) {
    OutlinedTextField(
        value = txt.value,
        onValueChange = {
            txt.value = it
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text12PxPoppinsNormal400LightGrey(text = placeHolder)
        },
        shape = RoundedCornerShape(10.dp),
        textStyle = TextStyle(color = if (isSystemInDarkTheme()) Color.White else Color.Gray),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFE0E0E0),
            unfocusedBorderColor = Color(0xFFE0E0E0)
        ),
        keyboardOptions = keyboardOptions,
        visualTransformation = VisualTransformation.None,
    )
}

@Composable
fun TextFieldPassword(
    placeHolder: String,
    txt: MutableState<String>,
) {
    val showPass = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = txt.value,
        onValueChange = {
            txt.value = it
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        placeholder = {
            Text12PxPoppinsNormal400LightGrey(text = placeHolder)
        },
        shape = RoundedCornerShape(10.dp),
        textStyle = TextStyle(color = if (isSystemInDarkTheme()) Color.White else Color.Gray),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFE0E0E0),
            unfocusedBorderColor = Color(0xFFE0E0E0)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = {
                showPass.value = !showPass.value
            }) {
                if (showPass.value) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.eye),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                    )
                } else {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.eye),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color(0xFF828282))
                    )
                }
            }
        },
        visualTransformation = if (!showPass.value) PasswordVisualTransformation() else VisualTransformation.None,
    )
}
