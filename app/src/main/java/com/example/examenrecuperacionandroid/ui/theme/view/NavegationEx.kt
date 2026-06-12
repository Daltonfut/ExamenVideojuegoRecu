package com.example.examenrecuperacionandroid.ui.theme.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.examenrecuperacionandroid.ui.theme.navegacion.Routes

@Composable
fun NavegacionEx() {
    val stack = remember { mutableStateListOf<Routes>(Routes.Login) }

    NavDisplay(
        backStack = stack,
        onBack = { 
            if (stack.size > 1) stack.removeAt(stack.size - 1) 
        }
    ) { key: Routes ->
        NavEntry(key) {
            when (key) {
                is Routes.Login -> LoginScreen(onLoginSuccess = { stack.add(Routes.Home) })
                is Routes.Home -> HomeScreen(
                    onNavigateToNuevo = { stack.add(Routes.NuevoJuego) },
                    onLogout = { if (stack.size > 1) stack.removeAt(stack.size - 1) }
                )
                is Routes.NuevoJuego -> NuevoJuegoScreen(onBack = { if (stack.size > 1) stack.removeAt(stack.size - 1) })
            }
        }
    }
}