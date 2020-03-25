package com.example.jetpack_compose_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Call composable functions within setContent
        setContent {
            myApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun myApp(children: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.Yellow) {
            children()
        }
    }
}

@Composable
fun MyScreenContent(
    names: List<String> = listOf("Android", "there"),
    counterState: CounterState = CounterState()
) {
    Column {
        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, height = 32.dp)
        Counter(state = counterState)
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = LayoutPadding(24.dp))
}

@Model
class CounterState(var count: Int = 0)

@Composable
fun Counter(state: CounterState) {
    Button(onClick = { state.count++ }) {
        Text(text = "I 've been clicked ${state.count} times")
    }
}

@Preview
@Composable
fun DefaultPreview() {
    myApp {
        MyScreenContent()
    }
}
