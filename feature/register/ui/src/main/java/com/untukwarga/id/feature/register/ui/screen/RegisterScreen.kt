package com.untukwarga.id.feature.register.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.untukwarga.id.core.common.*
import com.untukwarga.id.feature.register.domain.model.KabupatenKotaModel
import com.untukwarga.id.feature.register.domain.model.KecamatanModel
import com.untukwarga.id.feature.register.domain.model.KelurahanModel
import com.untukwarga.id.feature.register.domain.model.ProvinsiModel

/**
 * @author Robin D. Putera
 * @date 07/07/2023
 */

@Composable
fun RegisterScreen(viewModel: RegisterViewModel, navHostController: NavHostController) {

    val provinceResult = viewModel.provinceModel.value
    val cityResult = viewModel.cityModel.value
    val districtResult = viewModel.districtModel.value
    val subDistrictResult = viewModel.subDistrictModel.value

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
            RegisterHeader(navHostController = navHostController)
            RegisterContent(
                provinceResult,
                cityResult,
                districtResult,
                subDistrictResult,
                viewModel,
                navHostController
            )
        }
    }
}

@Composable
fun RegisterContent(
    provinceResult: GetProvinceStateHolder,
    cityResult: GetCityStateHolder,
    districtResult: GetDistrictStateHolder,
    subDistrictResult: GetSubDistrictStateHolder,
    viewModel: RegisterViewModel,
    navHostController : NavHostController
) {
    val txtUsername = remember { mutableStateOf("") }
    val txtWA = remember { mutableStateOf("") }
    val txtProvinsi = remember { mutableStateOf("") }
    val txtKabupaten = remember { mutableStateOf("") }
    val txtKecamatan = remember { mutableStateOf("") }
    val txtKelurahan = remember { mutableStateOf("") }
    val txtPassword = remember { mutableStateOf("") }
    val txtConfirmPassword = remember { mutableStateOf("") }
    val btnActive = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Text24PxJakartaBold700(text = "Registrasi")

        Spacer(modifier = Modifier.height(24.dp))
        Text14PxJakartaMedium600(text = "Nama Lengkap")
        Spacer(modifier = Modifier.height(8.dp))
        TextFieldCustom(
            placeHolder = "Isi nama lengkap",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            txt = txtUsername
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text14PxJakartaMedium600(text = "No. Whatsapp")
        Spacer(modifier = Modifier.height(8.dp))
        TextFieldCustom(
            placeHolder = "Isi nomor whatsapp",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            txt = txtWA
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text14PxJakartaMedium600(text = "Kata Sandi")
        Spacer(modifier = Modifier.height(8.dp))
        TextFieldPassword(placeHolder = "Masukkan kata sandi", txt = txtPassword)

        Spacer(modifier = Modifier.height(16.dp))
        Text14PxJakartaMedium600(text = "Ulangi Kata Sandi")
        Spacer(modifier = Modifier.height(8.dp))
        TextFieldPassword(placeHolder = "Ulangi kata sandi", txt = txtConfirmPassword)

        Spacer(modifier = Modifier.height(16.dp))
        Text14PxJakartaMedium600(text = "Lokasi Saat Ini")
        Spacer(modifier = Modifier.height(8.dp))
        if (provinceResult.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(40.dp)
                    .align(CenterHorizontally)
            )
        } else if (provinceResult.data != null) {
            DropDownLocationOption(
                placeHolder = "Pilih Provinsi",
                listOptionProvince = provinceResult.data,
                listOptionCity = null,
                listOptionDistrict = null,
                listOptionSubDistrict = null,
                currentLocationType = LocationConstant.locationProvince,
                provinceSelected = txtProvinsi,
                citySelected = txtKabupaten,
                districtSelected = txtKecamatan,
                subDistrictSelected = txtKelurahan,
                viewModel = viewModel
            )
        } else {
            Text12PxPoppinsNormal400Grey(text = provinceResult.error)
        }

        if (txtProvinsi.value != "") {
//            Spacer(modifier = Modifier.height(16.dp))
//            Text14PxJakartaMedium600(text = "Kabupaten/Kota")
            Spacer(modifier = Modifier.height(8.dp))
            if (cityResult.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(40.dp)
                        .align(CenterHorizontally)
                )
            } else if (cityResult.data != null) {
                DropDownLocationOption(
                    placeHolder = "Pilih Kabupaten/Kota",
                    listOptionProvince = null,
                    listOptionCity = cityResult.data,
                    listOptionDistrict = null,
                    listOptionSubDistrict = null,
                    currentLocationType = LocationConstant.locationKabupatenKota,
                    provinceSelected = txtProvinsi,
                    citySelected = txtKabupaten,
                    districtSelected = txtKecamatan,
                    subDistrictSelected = txtKelurahan,
                    viewModel = viewModel
                )
            } else {
                Text12PxPoppinsNormal400Grey(text = cityResult.error)
            }
        }

        if (txtKabupaten.value != "") {
//            Spacer(modifier = Modifier.height(16.dp))
//            Text14PxJakartaMedium600(text = "Kecamatan")
            Spacer(modifier = Modifier.height(8.dp))
            if (districtResult.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(40.dp)
                        .align(CenterHorizontally)
                )
            } else if (districtResult.data != null) {
                DropDownLocationOption(
                    placeHolder = "Pilih Kecamatan",
                    listOptionProvince = null,
                    listOptionCity = null,
                    listOptionDistrict = districtResult.data,
                    listOptionSubDistrict = null,
                    currentLocationType = LocationConstant.locationKecamatan,
                    provinceSelected = txtProvinsi,
                    citySelected = txtKabupaten,
                    districtSelected = txtKecamatan,
                    subDistrictSelected = txtKelurahan,
                    viewModel = viewModel
                )
            } else {
                Text12PxPoppinsNormal400Grey(text = districtResult.error)
            }
        }

        if (txtKecamatan.value != "") {
//            Spacer(modifier = Modifier.height(16.dp))
//            Text14PxJakartaMedium600(text = "Kelurahan/Desa")
            Spacer(modifier = Modifier.height(8.dp))
            if (subDistrictResult.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(40.dp)
                        .align(CenterHorizontally)
                )
            } else if (subDistrictResult.data != null) {
                DropDownLocationOption(
                    placeHolder = "Pilih Kelurahan/Desa",
                    listOptionProvince = null,
                    listOptionCity = null,
                    listOptionDistrict = null,
                    listOptionSubDistrict = subDistrictResult.data,
                    currentLocationType = LocationConstant.locationKelurahan,
                    provinceSelected = txtProvinsi,
                    citySelected = txtKabupaten,
                    districtSelected = txtKecamatan,
                    subDistrictSelected = txtKelurahan,
                    viewModel = viewModel
                )
            } else {
                Text12PxPoppinsNormal400Grey(text = districtResult.error)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (
            txtUsername.value != "" &&
            txtWA.value != "" &&
            txtPassword.value != "" &&
            txtConfirmPassword.value != "" &&
            txtProvinsi.value != "" &&
            txtKabupaten.value != "" &&
            txtKecamatan.value != ""
        ) {
            if (!btnActive.value) btnActive.value = true
        } else {
            if (btnActive.value) btnActive.value = false
        }
        val isLoading = remember { mutableStateOf(false) }
        if (btnActive.value){
            ButtonLogin(
                text = "Daftar Sekarang",
                isActive = true,
                modifier = Modifier.clickable {
                    isLoading.value = !isLoading.value
                },
                isLoading = isLoading
            )
        }else{
            isLoading.value = false
            ButtonLogin(
                text = "Daftar Sekarang",
                isActive = false,
                modifier = Modifier,
                isLoading = isLoading
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.fillMaxWidth()){
            Row(modifier = Modifier.align(Alignment.Center)) {
                Text12PxPoppinsNormal400Grey(text = "Sudah punya akun?")
                Spacer(modifier = Modifier.width(8.dp))
                Text12PxPoppinsMedium400Primary(
                    text = "Masuk sekarang",
                    modifier = Modifier.clickable {
                        navHostController.popBackStack()
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun RegisterHeader(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            ButtonBack(navHostController = navHostController)
            Spacer(modifier = Modifier.width(16.dp))
            Text14PxJakartaMedium600(text = "Daftar Akun")
        }

    }
}


@Composable
fun DropDownLocationOption(
    listOptionProvince: List<ProvinsiModel>?,
    listOptionCity: List<KabupatenKotaModel>?,
    listOptionDistrict: List<KecamatanModel>?,
    listOptionSubDistrict: List<KelurahanModel>?,
    placeHolder: String,
    currentLocationType: Int,
    provinceSelected: MutableState<String>,
    citySelected: MutableState<String>,
    districtSelected: MutableState<String>,
    subDistrictSelected: MutableState<String>,
    viewModel: RegisterViewModel
) {
    val expanded = remember {
        mutableStateOf(false)
    }

    val selection =
        when (currentLocationType) {
            LocationConstant.locationProvince -> provinceSelected
            LocationConstant.locationKabupatenKota -> citySelected
            LocationConstant.locationKecamatan -> districtSelected
            else -> subDistrictSelected
        }
    val listOption = when (currentLocationType) {
        LocationConstant.locationProvince -> listOptionProvince
        LocationConstant.locationKabupatenKota -> listOptionCity
        LocationConstant.locationKecamatan -> listOptionDistrict
        else -> listOptionSubDistrict
    }
    val configuration = LocalConfiguration.current

    val screenWidth = configuration.screenWidthDp.dp

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = if (selection.value == "") placeHolder else selection.value,
            onValueChange = {
                selection.value = it
            },
            singleLine = true,
            enabled = false,
            shape = RoundedCornerShape(10.dp),
            textStyle = TextStyle(color = if (isSystemInDarkTheme()) Color.White else Color.Gray),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFE0E0E0),
                unfocusedBorderColor = Color(0xFFE0E0E0),
                disabledBorderColor = Color(0xFFE0E0E0),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    expanded.value = !expanded.value
                },
            trailingIcon = {
                if (expanded.value) {
                    Image(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color(0xFF828282)),
                        modifier = Modifier.clickable {
                            expanded.value = false
                        }
                    )
                } else {
                    Image(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color(0xFF828282)),
                        modifier = Modifier.clickable {
                            expanded.value = true
                        }
                    )
                }
            },
        )

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier.width(screenWidth - 32.dp)
        ) {
            listOption!!.forEach { label ->
                DropdownMenuItem(onClick = {
                    selection.value = when (currentLocationType) {
                        LocationConstant.locationProvince -> (label as ProvinsiModel).name
                        LocationConstant.locationKabupatenKota -> (label as KabupatenKotaModel).name
                        LocationConstant.locationKecamatan -> (label as KecamatanModel).name
                        else -> (label as KelurahanModel).name
                    }
                    expanded.value = false
                    val idJson = when (currentLocationType) {
                        LocationConstant.locationProvince -> "${(label as ProvinsiModel).id}.json"
                        LocationConstant.locationKabupatenKota -> "${(label as KabupatenKotaModel).id}.json"
                        LocationConstant.locationKecamatan -> "${(label as KecamatanModel).id}.json"
                        else -> "${(label as KelurahanModel).id}.json"
                    }
                    when (currentLocationType) {
                        LocationConstant.locationProvince -> {
                            citySelected.value = ""
                            districtSelected.value = ""
                            subDistrictSelected.value = ""
                            viewModel.getCityList(idJson)
                        }
                        LocationConstant.locationKabupatenKota -> {
                            districtSelected.value = ""
                            subDistrictSelected.value = ""
                            viewModel.getDistrictList(idJson)
                        }
                        LocationConstant.locationKecamatan -> {
                            subDistrictSelected.value = ""
                            viewModel.getSubDistrictList(idJson)
                        }
                    }
                }) {
                    val txt = when (currentLocationType) {
                        LocationConstant.locationProvince -> (label as ProvinsiModel).name
                        LocationConstant.locationKabupatenKota -> (label as KabupatenKotaModel).name
                        LocationConstant.locationKecamatan -> (label as KecamatanModel).name
                        else -> (label as KelurahanModel).name
                    }
                    Text(text = txt)
                }
            }
        }

    }

}
