package com.example.areavolumen_joro.figuras

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.areavolumen_joro.R
import com.example.areavolumen_joro.Routes
import com.example.areavolumen_joro.utilidades.BotonPrimario
import com.example.areavolumen_joro.utilidades.EntradaNumerica
import com.example.areavolumen_joro.utilidades.Imagen
import com.example.areavolumen_joro.utilidades.Texto
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun CalcularDodecaedro (navController: NavController) {
    Column (
        Modifier
            .fillMaxSize()
            .padding(vertical = 100.dp, horizontal = 50.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val longitud = remember { mutableDoubleStateOf(0.0) }

        Imagen (R.drawable.dodecaedro, 1f)          // Imagen de la figura

        Spacer (modifier = Modifier.height(20.dp))
        Imagen (R.drawable.area_dodecaedro, 0.6f)   // Imagen de la fórmula de área
        Imagen (R.drawable.vol_dodecaedro, 0.6f)    // Imagen de la fórmula de volumen
        Spacer (modifier = Modifier.height(20.dp))

        Texto ("Datos necesarios:", true)

        // Ingresar longitud de los lados
        EntradaNumerica ("Longitud de los lados (a)", longitud)

        BotonPrimario ("Calcular", true) {

            // Calcular resultado
            val area = 3 * sqrt(25 + (10 * sqrt(5.0) * longitud.doubleValue.pow(2)))
            val volumen = ((15 + 7 * sqrt(5.0))/4) * longitud.doubleValue.pow(3)

            // Formatear resultado a 2 decimales
            val arg_area = "%.2f".format(area)
            val arg_vol = "%.2f".format(volumen)

            // Ir a pantalla de resultado
            navController.navigate (
                Routes.PantallaResultado.route + "/$arg_area/$arg_vol"
            )
        }
    }
}