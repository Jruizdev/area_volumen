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

@Composable
fun CalcularToroide (navController: NavController) {
    Column (
        Modifier
            .fillMaxSize()
            .padding(vertical = 100.dp, horizontal = 50.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val r_gen = remember { mutableDoubleStateOf(0.0) }
        val r_dir = remember { mutableDoubleStateOf(0.0) }

        Imagen (R.drawable.toroide, 1f)          // Imagen de la figura

        Spacer (modifier = Modifier.height(20.dp))
        Imagen (R.drawable.area_toroide, 0.6f)   // Imagen de la fórmula de área
        Imagen (R.drawable.vol_toroide, 0.6f)    // Imagen de la fórmula de volumen
        Spacer (modifier = Modifier.height(20.dp))

        Texto ("Datos necesarios:", true)

        EntradaNumerica ("Radio del circulo generatriz (r)", r_gen)
        EntradaNumerica ("Circunferencia directriz (R)", r_dir)

        BotonPrimario ("Calcular", true) {

            // Calcular resultado
            val area = 4 * Math.PI.pow(2) * r_dir.doubleValue * r_gen.doubleValue
            val volumen = 2 * Math.PI.pow(2) * r_dir.doubleValue * r_gen.doubleValue.pow(2)

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