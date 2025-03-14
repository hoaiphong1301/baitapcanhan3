package com.example.lanthuthu10

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.jetpack_logo), // Đảm bảo ảnh tồn tại trong res/drawable
            contentDescription = "Jetpack Compose"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Jetpack Compose", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navController.navigate("components") }) {
            Text("I'm ready")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    val navController = rememberNavController()
    WelcomeScreen(navController)
}
