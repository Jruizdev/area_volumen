package com.example.areavolumen_joro

sealed class Routes (val route: String) {
    object PantallaInicio : Routes ("inicio")
    object CalcularEsfera : Routes ("esfera")
    object CalcularCilindro : Routes ("cilindro")
    object CalcularCono : Routes ("cono")
    object CalcularDodecaedro : Routes ("dodecaedro")
    object CalcularPrismaPentagonal : Routes ("prisma")
    object CalcularToroide: Routes ("toroide")
    object CalcularCubo: Routes ("cubo")
    object CalcularPiramideCuadrada: Routes ("piramide")
    object PantallaResultado : Routes ("resultado")
    object AcercaDe : Routes ("acerca")
}
