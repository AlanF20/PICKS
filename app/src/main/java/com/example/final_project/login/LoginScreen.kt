package com.example.final_project.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.final_project.R

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Login(modifier: Modifier = Modifier) {
     val provider = GoogleFont.Provider(
            providerAuthority = "com.google.android.gms.fonts",
            providerPackage = "com.google.android.gms",
            certificates = R.array.com_google_android_gms_fonts_certs
        )
    Box {
        Column(modifier = modifier
            .fillMaxSize()
            .size(200.dp, height = 200.dp)
            ){
            Image(
                painter = painterResource(id = R.drawable.image_1),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

        }
        val fontName2 = GoogleFont(name = "Fjalla One")
        val fontFamily2 = FontFamily(Font(googleFont = fontName2, fontProvider = provider))
        val noPad = androidx.compose.ui.text.TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false,
            )
        )
        var user by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Column (
            modifier = modifier
                .padding(top = 280.dp)
                .background(color = Color.Transparent)
                .clip(RoundedCornerShape(20.dp))
        ){
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .fillMaxHeight()
                    .padding(20.dp)
            ){
                Column {
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = "Iniciar sesión",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        style = noPad,
                        fontFamily = fontFamily2
                    )
                    Spacer(modifier = modifier.height(15.dp))
                    OutlinedTextField(
                        value = user,
                        onValueChange = { user = it},
                        modifier = modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Person, contentDescription = null)
                        },
                        label = {Text(text = "Usuario", fontFamily = fontFamily2, style = noPad, color = Color(0xFF7C7C7C))},
                        colors = TextFieldDefaults.outlinedTextFieldColors(Color(0xFF7C7C7C))
                    )
                    Spacer(modifier = modifier.height(30.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it},
                        modifier = modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                        },
                        label = {Text(text = "Contraseña", fontFamily = fontFamily2, style = noPad, color = Color(0xFF7C7C7C))},
                        colors = TextFieldDefaults.outlinedTextFieldColors(Color(0xFF7C7C7C))
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Text(text = "¿No tienes una cuenta?,", fontFamily = fontFamily2, style = noPad, color = Color(0xFF7C7C7C))
                        Spacer(modifier = modifier.width(5.dp))
                        Text(text = "crea una aquí.", color = Color(0xFF4B76E4), fontFamily = fontFamily2, style = noPad)
                    }
                    Spacer(modifier = modifier.height(30.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFE5F33C))
                    ){
                        Text(
                            text = "Entrar",
                            fontSize = 24.sp,
                            fontFamily = fontFamily2,
                            style = noPad,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                            )
                    }
                    Spacer(modifier = modifier.height(30.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    ) {
                        Spacer(
                            modifier = modifier
                                .width(165.dp)
                                .height(1.dp)
                                .background(Color(0xFFC0C0C0))
                        )
                        Text(text = "O", fontFamily = fontFamily2, style = noPad, color = Color(0xFF7C7C7C), modifier = modifier.padding(10.dp))
                        Spacer(
                            modifier = modifier
                                .width(200.dp)
                                .height(1.dp)
                                .background(Color(0xFFC0C0C0))
                        )
                    }
                    Spacer(modifier = modifier.height(30.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                        modifier = modifier
                            .fillMaxWidth()
                    ){
                        Image(painterResource(id = R.drawable.vector), contentDescription = null)
                        Image(painterResource(id = R.drawable.flat_color_icons_google), contentDescription = null, modifier = modifier.size(40.dp))
                        Image(painterResource(id = R.drawable.vector__1_), contentDescription = null)
                    }
                }
            }
        }
    }
}