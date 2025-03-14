package com.example.lanthuthu10
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.navigation.NavController

@Composable
fun TextDetailScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(16.dp)
        ) {
            Text(
                buildAnnotatedString {
                    append("The ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                        append("quick ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color(0xFFFF9800))) {
                        append("Brown ")
                    }
                    append("fox j")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("u")
                    }
                    append("mps ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("over ")
                    }
                    append("the ")
                    withStyle(style = SpanStyle(fontStyle = FontStyle.Italic)) {
                        append("lazy ")
                    }
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("dog.")
                    }
                },
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextDetailScreenPreview() {
    TextDetailScreen(navController = rememberNavController())
}