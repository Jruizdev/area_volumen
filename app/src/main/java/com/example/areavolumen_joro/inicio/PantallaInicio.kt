package com.example.areavolumen_joro.inicio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.areavolumen_joro.MainActivity
import com.example.areavolumen_joro.R
import com.example.areavolumen_joro.Routes
import com.example.areavolumen_joro.utilidades.*
import kotlin.system.exitProcess

@Composable
fun PantallaInicio (navController: NavController) {
    Column (
        Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Titulo ("Áreas y Volúmenes")
        Spacer (modifier = Modifier.height(30.dp))
        Imagen (R.drawable.portada, 1f)
        BotonPrimario ("Acerca de...", true) {

            // Ir a pantalla "Acerca de.."
            navController.navigate (Routes.AcercaDe.route)
        }
        BotonSecundario ("Salir", true) {

            // Salir de la aplicación
            MainActivity ().finish()
            exitProcess (0)
        }
    }
}