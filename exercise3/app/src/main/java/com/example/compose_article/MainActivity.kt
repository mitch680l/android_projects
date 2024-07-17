package com.example.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            )
            {
                Banner(
                    title = stringResource(R.string.title),
                    para1 = stringResource(R.string.para1),
                    para2 = stringResource(R.string.para2)

                )
            }
            }
        }
    }

@Composable
fun Article_text(title: String, para1: String, para2: String, modifier: Modifier = Modifier)  {
    Column (
        modifier = modifier.padding(4.dp),
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text (
            text = para1,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        )
        Text (
            text = para2,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun Banner(title: String, para1: String, para2: String, modifier: Modifier = Modifier) {
    val img = painterResource(R.drawable.bg_compose_background)

    Column(modifier) {
        Image(
            painter = img,
            contentDescription = null
        )
        Article_text(
            title = stringResource(R.string.title),
            para1 = stringResource(R.string.para1),
            para2 = stringResource(R.string.para2),
            modifier = Modifier.padding(8.dp)
        )
    }
}




@Preview(showBackground = true)
@Composable
fun Preview() {
    Banner(
        title = stringResource(R.string.title),
        para1 = stringResource(R.string.para1),
        para2 = stringResource(R.string.para2)

    )
}