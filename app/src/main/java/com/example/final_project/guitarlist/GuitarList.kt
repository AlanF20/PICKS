package com.example.final_project.guitarlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.final_project.R

class GuitarList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {}
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showSystemUi = true, showBackground = true
)
@Composable
fun GuitarListBody(modifier: Modifier = Modifier) {
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    val fontName2 = GoogleFont(name = "Fjalla One")
    val fontFamily2 = FontFamily(Font(googleFont = fontName2, fontProvider = provider))
    val noPad = androidx.compose.ui.text.TextStyle(
        platformStyle = PlatformTextStyle(
            includeFontPadding = false,
        )
    )
    var searchText by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        Row(
            modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Bienvenido,",
                    fontFamily = fontFamily2,
                    fontSize = 24.sp,
                    color = Color(0x59000000),
                    style = noPad
                )
                Text(
                    text = "Alan Flores", fontFamily = fontFamily2, fontSize = 24.sp, style = noPad
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ellipse_1),
                contentDescription = null,
                modifier = modifier
                    .height(54.dp)
                    .width(54.dp)
            )
        }
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                modifier = modifier
                    .padding(top = 20.dp)
                    .weight(1f),
                value = searchText,
                onValueChange = { searchText = it },
                shape = RoundedCornerShape(15.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = "Buscar", fontFamily = fontFamily2, fontSize = 16.sp, style = noPad
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(Color(0xFFA6A6A6))
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Todas", fontFamily = fontFamily2, fontSize = 14.sp, style = noPad
            )
            Text(
                text = "Electricas",
                fontFamily = fontFamily2,
                fontSize = 14.sp,
                style = noPad,
                color = Color(0xFFA6A6A6)
            )
            Text(
                text = "Acusticas",
                fontFamily = fontFamily2,
                fontSize = 14.sp,
                style = noPad,
                color = Color(0xFFA6A6A6)
            )
            Text(
                text = "Requinto",
                fontFamily = fontFamily2,
                fontSize = 14.sp,
                style = noPad,
                color = Color(0xFFA6A6A6)
            )
        }
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "No hay guitarras disponibles.",
                fontFamily = fontFamily2,
                fontSize = 24.sp,
                style = noPad
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true
)
@Composable
fun GuitarCard(modifier: Modifier = Modifier){
    Card(
        onClick = { /*TODO*/ },
        modifier = modifier
            .width(300.dp)
            .height(175.dp)
    ){
        Box {
            Image(painter = painterResource(id = R.drawable.image_2), contentDescription = null)
        }
    }
}

