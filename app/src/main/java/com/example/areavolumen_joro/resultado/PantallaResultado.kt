package com.example.areavolumen_joro.resultado

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.areavolumen_joro.Routes
import com.example.areavolumen_joro.utilidades.*

@SuppressLint("DefaultLocale")
@Composable
fun PantallaResultado (
    navController: NavController,
    area: String? = "0",
    volumen: String? = "0",
    tituloApp: MutableState<String>
) {
    val titulo = "Cálculo de la Figura"

    Column (
        Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 50.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Titulo (titulo) // Indicar figura calculada
        Spacer (modifier = Modifier.height(30.dp))

        // Resultado del área calculada
        FilaDatos ("Área:", area?: "0")

        // Resultado del volúmen calculado
        FilaDatos ("Volúmen:", volumen?: "0")

        Spacer (modifier = Modifier.height(30.dp))
        BotonPrimario ("Salir", true) {

            tituloApp.value = "Inicio"

            // Regresar a la pantalla de inicio
            navController.navigate (
                Routes.PantallaInicio.route
            )
        }
    }
}