package com.example.examenrecuperacionandroid.ui.theme.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examenrecuperacionandroid.R
import com.example.examenrecuperacionandroid.ui.theme.modelo.Juego

@Composable
fun HomeScreen() {
    val juegos = listOf<Juego>(
        Juego("s","s","s","s",5.0,"")
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.ps),
                contentDescription = "pruebaImg"
            )
            Text(
                text = "fff"
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewHome(){
    HomeScreen()
}