package com.example.examenrecuperacionandroid.ui.theme.navegacion

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey{
    @Serializable
    object Login : Routes()

    @Serializable
    object Home : Routes()

    @Serializable
    object NuevoJuego : Routes()
}