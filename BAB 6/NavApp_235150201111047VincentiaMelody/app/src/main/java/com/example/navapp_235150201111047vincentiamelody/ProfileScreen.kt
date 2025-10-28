package com.example.navapp_235150201111047vincentiamelody

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is Profile Screen")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navController.navigate("home")

        }) {
            Text("Back to Home")
        }
    }
}