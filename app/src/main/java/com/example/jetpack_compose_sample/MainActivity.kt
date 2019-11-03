package com.example.jetpack_compose_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Spacing
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Call composable functions within setContent
        setContent {
            MaterialTheme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Yellow) {
        Text(text = "Hello $name!", modifier = Spacing(24.dp))
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        Greeting("Android")
    }
}
