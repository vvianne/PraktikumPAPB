package com.example.praktikum3_state_235150201111047vincentiamelody

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum3_state_235150201111047vincentiamelody.ui.theme.Praktikum3_State_235150201111047VincentiaMelodyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Praktikum3_State_235150201111047VincentiaMelodyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(40.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Counter",
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        CounterScreen()
                        Spacer(modifier = Modifier.height(40.dp))

                        Text(
                            text = "Tombol Warna",
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        ColorToggleScreen()
                        Spacer(modifier = Modifier.height(40.dp))

                        Text(
                            text = "Profil",
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        ProfileScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun CounterScreen() {
    var count by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { if (count > 0) count-- },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(painter = painterResource(id = android.R.drawable.ic_input_delete), contentDescription = "Kurang")
        }
        Text(
            text = "$count",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        IconButton(
            onClick = { count++ },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(painter = painterResource(id = android.R.drawable.ic_input_add), contentDescription = "Tambah")
        }
    }
}

@Composable
fun ColorToggleScreen() {
    var isRed by remember { mutableStateOf(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(if (isRed) Color.Red else Color.Green)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { isRed = !isRed }) {
            Text(text = "Ganti Warna")
        }
    }
}

@Composable
fun ProfileScreen() {
    var isFollowing by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_dummy),
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Vincentia Melody Vivianne",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Suka void cat, lucu soalnya.",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { isFollowing = !isFollowing }) {
            Text(text = if (isFollowing) "Unfollow" else "Follow")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = if (isFollowing) "Anda mengikuti akun ini" else "Anda belum mengikuti akun ini",
            fontSize = 14.sp,
            color = if (isFollowing) Color.Blue else Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Counter", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            CounterScreen()
            Spacer(modifier = Modifier.height(40.dp))

            Text(text = "Tombol Warna", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            ColorToggleScreen()
            Spacer(modifier = Modifier.height(40.dp))

            Text(text = "Profil", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            ProfileScreen()
        }
    }
}

@Composable
fun ComposableAppTheme(content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}