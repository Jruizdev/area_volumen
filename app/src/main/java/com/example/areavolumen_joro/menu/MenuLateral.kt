package com.example.areavolumen_joro.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.areavolumen_joro.MenuItem
import com.example.areavolumen_joro.Routes
import kotlinx.coroutines.CoroutineScope
import com.example.areavolumen_joro.utilidades.*
import kotlinx.coroutines.launch

@Composable
fun BarraMenu (
    titulo: MutableState<String>,
    scope: CoroutineScope,
    drawerState: DrawerState,
    navController: NavController
) {
    Column (Modifier.fillMaxSize()) {
        DrawerHeader ()
        DrawerBody (
            items = listOf (

                // Crear opciones del menú
                MenuItem ("inicio","Inicio"),
                MenuItem ("esfera","Calcular esfera"),
                MenuItem ("cilindro","Calcular cilindro"),
                MenuItem ("cono","Calcular cono"),
                MenuItem ("dodecaedro","Calcular dodecaedro"),
                MenuItem ("prisma","Calcular prisma pentagonal"),
                MenuItem ("toroide","Calcular toroide"),
                MenuItem ("cubo","Calcular cubo"),
                MenuItem ("piramide","Calcular piramide cuadrada")
            ),
            onItemClick = {item ->
                scope.launch {
                    drawerState.close()
                    when (item.id) {
                        "inicio" -> {
                            titulo.value = "Inicio"
                            navController.navigate (Routes.PantallaInicio.route)
                        }
                        "esfera" -> {
                            titulo.value = "Área y Volumen de Esfera"
                            navController.navigate (Routes.CalcularEsfera.route)
                        }
                        "cilindro" -> {
                            titulo.value = "Área y Volumen de Cilindro"
                            navController.navigate (Routes.CalcularCilindro.route)
                        }
                        "cono" -> {
                            titulo.value = "Área y Volumen de Cono"
                            navController.navigate (Routes.CalcularCono.route)
                        }
                        "dodecaedro" -> {
                            titulo.value = "Área y Volumen de Dodecaedro"
                            navController.navigate (Routes.CalcularDodecaedro.route)
                        }
                        "prisma" -> {
                            titulo.value = "Área y Volumen de Prisma Pentagonal"
                            navController.navigate (Routes.CalcularPrismaPentagonal.route)
                        }
                        "toroide" -> {
                            titulo.value = "Área y Volumen de Toroide"
                            navController.navigate (Routes.CalcularToroide.route)
                        }
                        "cubo" -> {
                            titulo.value = "Área y Volumen de Cubo"
                            navController.navigate (Routes.CalcularCubo.route)
                        }
                        "piramide" -> {
                            titulo.value = "Área y Volumen de Pirámide Cuadrada"
                            navController.navigate (Routes.CalcularPiramideCuadrada.route)
                        }
                    }
                }
            }
        )
    }
}