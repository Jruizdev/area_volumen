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
import com.example.areavolumen_joro.MainActivity
import com.example.areavolumen_joro.utilidades.*
import kotlin.system.exitProcess

@Composable
fun AcercaDe () {
    Column (
        Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Mostrar información  de la aplicación
        Titulo ("Aplicación Áreas y Volúmenes")
        Spacer (modifier = Modifier.height (30.dp))
        FilaDatos (etiqueta = "Versión:", dato = "2.0")
        FilaDatos (etiqueta = "Fecha de programación:", dato = "31/05/24")
        FilaDatos (etiqueta = "Nombre:", dato = "Jonathan Ruiz Olvera")
        FilaDatos (etiqueta = "Matrícula:", dato = "ES202100495")
        FilaDatos (etiqueta = "Grupo:", dato = "DS-DPMO-2401-B2-002")
        FilaDatos (etiqueta = "Unidad didáctica:", dato = "Programación Móvil")
        FilaDatos (etiqueta = "Figura académica:", dato = "Verónica Espinoza Romo")
        Spacer (modifier = Modifier.height (30.dp))
        BotonPrimario(texto = "Salir", fillWidth = true) {

            // Salir de la aplicación
            MainActivity ().finish()
            exitProcess (0)
        }
    }
}