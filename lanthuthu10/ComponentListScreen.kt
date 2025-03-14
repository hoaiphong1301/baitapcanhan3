package com.example.lanthuthu10
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.navigation.NavController

@Composable
fun ComponentListScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("UI Components List", style = MaterialTheme.typography.headlineSmall, color = Color.Blue)
        Spacer(modifier = Modifier.height(16.dp))

        val components = listOf(
            "Text" to "Displays text",
            "Image" to "Displays an image",
            "TextField" to "Input field for text",
            "PasswordField" to "Input field for passwords",
            "Column" to "Arranges elements vertically",
            "Row" to "Arranges elements horizontally"
        )

        components.forEach { (title, description) ->
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .clickable { if (title == "Text") navController.navigate("textDetail") }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(title, fontWeight = FontWeight.Bold)
                    Text(description, fontSize = 12.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentListScreenPreview() {
    ComponentListScreen(navController = rememberNavController())
}