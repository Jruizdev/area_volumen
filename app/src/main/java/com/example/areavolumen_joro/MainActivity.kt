package com.example.areavolumen_joro

import android.annotation.SuppressLint
import com.example.areavolumen_joro.menu.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.areavolumen_joro.figuras.*
import com.example.areavolumen_joro.inicio.*
import com.example.areavolumen_joro.resultado.PantallaResultado
import com.example.areavolumen_joro.ui.theme.AreaVolumen_JOROTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AreaVolumen_JOROTheme {
                Inicio ()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Inicio () {

    // Variables de estados
    val drawerState = rememberDrawerState (initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope ()
    val navController = rememberNavController ()
    val titulo = remember { mutableStateOf("Inicio") }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

                // Barra de menú lateral
                BarraMenu (titulo, scope, drawerState, navController)
            }
        },
        gesturesEnabled = drawerState.isOpen
    ) {
        Scaffold (
            topBar = {
                BarraSuperior (titulo.value) {

                    // Mostrar barra de menú al seleccionar el ícono de la parte superior
                    scope.launch { drawerState.open() }
                }
            }
        ) {
            NavHost (
                navController = navController,
                startDestination = Routes.PantallaInicio.route
            ) {

                // Definir las rutas de navegación
                composable (Routes.AcercaDe.route) { AcercaDe() }
                composable (Routes.PantallaInicio.route) { PantallaInicio (navController) }
                composable (Routes.CalcularEsfera.route) { CalcularEsfera (navController) }
                composable (Routes.CalcularCilindro.route) { CalcularCilindro (navController) }
                composable (Routes.CalcularCono.route) { CalcularCono (navController) }
                composable (Routes.CalcularDodecaedro.route) { CalcularDodecaedro (navController) }
                composable (Routes.CalcularPrismaPentagonal.route) { CalcularPrismaPentagonal (navController) }
                composable (Routes.CalcularToroide.route) { CalcularToroide (navController) }
                composable (Routes.CalcularCubo.route) { CalcularCubo (navController) }
                composable (Routes.CalcularPiramideCuadrada.route) { CalcularPiramideCuadrada (navController) }
                composable (Routes.PantallaResultado.route + "/{area}/{volumen}"
                ) {bsEntry ->

                    // Obtener argumentos envidos
                    val area = bsEntry.arguments?.getString("area")
                    val volumen = bsEntry.arguments?.getString("volumen")

                    PantallaResultado (navController, area, volumen, titulo)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Previsualizacion () {
    AreaVolumen_JOROTheme {
        Inicio ()
    }
}