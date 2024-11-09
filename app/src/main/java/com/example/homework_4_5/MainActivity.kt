package com.example.homework_4_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.homework_4_5.components.LottieScreen
import com.example.homework_4_5.components.MainScreen
import com.example.homework_4_5.ui.theme.Homework45Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Homework45Theme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "lottieScreen") {
                    composable("lottieScreen") { LottieScreen(navController) }
                    composable("mainScreen") { MainScreen() }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Homework45Theme {
        MainScreen()
    }
}
