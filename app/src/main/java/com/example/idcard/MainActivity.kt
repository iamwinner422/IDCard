package com.example.idcard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idcard.ui.theme.IDCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IDCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IdCardApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun IdCardApp(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .background(Color(0xFFd3e8d5))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FirstSection()
        Spacer(modifier = Modifier.height(100.dp))
        SecondSection()
    }
}

@Composable
fun FirstSection(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ImageSection(image)
        TextSection(name = "iam winner", position = "Principal Software Engineer")
    }
}

@Composable
fun SecondSection(){
    Column{
        IconTextSection(Icons.Rounded.Call, "+22898023036")
        Spacer(modifier = Modifier.height(8.dp))
        IconTextSection(Icons.Rounded.Share, "@iamwinner422")
        Spacer(modifier = Modifier.height(8.dp))
        IconTextSection(Icons.Rounded.Email, "dzeglekwadzowinner@gmail.com")
    }
}

@Composable
fun ImageSection(image: Painter){
    Surface(
        color = Color(0xFF073142),
        shape = CircleShape,

    ) {
        Image(
            painter = image,
            contentDescription = "Android Logo",
            modifier = Modifier.width(160.dp).padding(8.dp, 16.dp)
        )
    }
}

@Composable
fun TextSection(name: String, position: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = name,
            fontSize = 40.sp, fontWeight = FontWeight.Light
        )
        Text(
            text = position,
            fontSize = 12.sp, fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun IconTextSection(icon: ImageVector, text: String){
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Icon(
            icon,
            contentDescription = "Call",
            tint = Color(0xFF3ddc84)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IDCardTheme {
        IdCardApp()
    }
}