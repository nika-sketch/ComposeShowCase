package com.example.composeshowcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeshowcase.animation.GraphicsLayerTextAnimation
import com.example.composeshowcase.animation.RotationTextAnimation
import com.example.composeshowcase.ui.theme.ComposeShowCaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeShowCaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SampleContent(innerPadding)
                }
            }
        }
    }
}

@Composable
fun SampleContent(padding: PaddingValues) {
    Column(
        modifier = Modifier.padding(padding)
    ) {
        GraphicsLayerTextAnimation(
            modifier = Modifier
                .padding(padding)
        )
        Spacer(modifier = Modifier.height(16.dp))

        RotationTextAnimation(
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeShowCaseTheme {
        Greeting("Android")
    }
}