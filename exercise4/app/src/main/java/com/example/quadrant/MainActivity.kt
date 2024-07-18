package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    View()
                }

            }
        }
    }
}
@Composable
fun Quadrant(title : String, paragraph : String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                bottom = 16.dp
            )
        )
        Text(
            text = paragraph,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun View(modifier: Modifier = Modifier) {
    Column(
        Modifier.fillMaxWidth()
    )
    {
        Row (
            modifier = Modifier.weight(
                weight = 1f,
                fill = true,
            )
        )
        {
            Quadrant(
                title = "Text composable",
                paragraph = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier
                    .background(color = Color(0xFFEADDFF)).weight(1f)
            )
            Quadrant(
                title = "Image composable",
                paragraph = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier
                    .background(color = Color(0xFFD0BCFF)).weight(1f)
            )
        }
        Row (
            modifier = Modifier.weight(
            weight = 1f,
            fill = true
            )
        )
        {
            Quadrant(
                title = "Row composable",
                paragraph = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier
                    .background(color = Color(0xFFB69DF8)).weight(1f)
            )
            Quadrant(
                title = "Column composable",
                paragraph = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier
                    .background(color = Color(0xFFF6EDFF)).weight(1f),
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadrantTheme {
        View()
    }
}