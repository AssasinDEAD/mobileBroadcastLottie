package com.example.homework_4_5.components

import androidx.compose.runtime.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.homework_4_5.R
import kotlinx.coroutines.delay
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun LottieScreen(navController: NavController) {
    var startInitialAnimation by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        startInitialAnimation = true
        delay(1000)
    }

    val scale by animateFloatAsState(
        targetValue = if (startInitialAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )
    val alpha by animateFloatAsState(
        targetValue = if (startInitialAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anima1))
    val progress by animateLottieCompositionAsState(
        composition = composition
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                alpha = alpha
            )
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.size(200.dp)
        )
    }

    LaunchedEffect(progress) {
        if (progress == 1f) {
            navController.navigate("mainScreen") {
                popUpTo("lottieScreen") { inclusive = true }
            }
        }
    }
}
