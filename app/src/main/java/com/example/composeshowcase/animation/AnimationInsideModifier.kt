package com.example.composeshowcase.animation

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign

/**
 * Composable is animating, reason: not using lambda, passing rotation angle float which is being changed every time..
 */
@Composable
fun RotationTextAnimation(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Text(
        textAlign = TextAlign.Center,
        text = "I am recomposing....",
        // Problem
        modifier = modifier.rotate(rotationAngle)
    )
}

/**
 * Composable is not animating, reason: Lambda
 */
@Composable
fun GraphicsLayerTextAnimation(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition()
    val rotationAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Text(
        textAlign = TextAlign.Center,
        text = "I am not recomposing",
        // Correct way
        modifier = modifier.graphicsLayer {
            rotationZ = rotationAngle
        }
    )
}