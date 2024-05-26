package com.example.final_project.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.final_project.R
import com.example.final_project.splash.ui.theme.Final_projectTheme

@SuppressLint("CustomSplashScreen")
class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Final_projectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun Splash(modifier: Modifier = Modifier, navController: NavController){
     val provider = GoogleFont.Provider(
            providerAuthority = "com.google.android.gms.fonts",
            providerPackage = "com.google.android.gms",
            certificates = R.array.com_google_android_gms_fonts_certs
        )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column {
                RoundedImages()
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                RoundedImages(height = 285,image = R.drawable.rectangle_11, alignment = Alignment.Center)
                Image(
                    painter = painterResource(id = R.drawable.tabler_guitar_pick),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 16.dp)
                )
            }
            Column(
                modifier = Modifier
                    .height(285.dp),
                verticalArrangement = Arrangement.Bottom,
            ){
                RoundedImages(height = 140,image = R.drawable.rectangle_12, alignment = Alignment.Center)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Spacer(modifier = Modifier.width(100.dp))
            }
            Column {
                RoundedImages(image = R.drawable.rectangle_13, height = 220)
            }
            Column {
                RoundedImages( image = R.drawable.rectangle_14, height = 140)
            }
        }
        val fontName = GoogleFont(name = "Poppins")
        val fontName2 = GoogleFont(name = "Fjalla One")
        val fontFamily = FontFamily(Font(googleFont = fontName, fontProvider = provider))
        val fontFamily2 = FontFamily(Font(googleFont = fontName2, fontProvider = provider))
        val noPad = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false,
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "PICK'S",
                color = Color.White,
                fontFamily = fontFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 56.sp,
                style = noPad
            )
            Text(
                text = "#PLAY YOUR PICK",
                color = Color(0xFFE5F33C),
                fontFamily = fontFamily2,
                fontSize = 24.sp,
                style = noPad,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Button(
                onClick = { navController.navigate("login") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ){
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "GET STARTED",
                        fontFamily = fontFamily2,
                        color = Color.Black,
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center,
                        style = noPad
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun RoundedImages(modifier: Modifier = Modifier, height: Int = 180, alignment: Alignment = Alignment.CenterEnd, image: Int = R.drawable.rectangle_10){
    val imageModi = Modifier
        .width(100.dp)
        .height(height.dp)
        .clip(RoundedCornerShape(60.dp))
        .background(Color.Transparent)
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        modifier = imageModi,
        alignment = alignment
    )
}