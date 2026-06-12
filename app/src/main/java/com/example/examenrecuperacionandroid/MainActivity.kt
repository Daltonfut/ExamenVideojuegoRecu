package com.example.examenrecuperacionandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.examenrecuperacionandroid.ui.theme.ExamenRecuperacionAndroidTheme
import com.example.examenrecuperacionandroid.ui.theme.view.NavegacionEx

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenRecuperacionAndroidTheme {
                NavegacionEx()
            }
        }
    }
}