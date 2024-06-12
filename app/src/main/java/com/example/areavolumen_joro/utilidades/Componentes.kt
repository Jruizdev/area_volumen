package com.example.areavolumen_joro.utilidades

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableDoubleState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.areavolumen_joro.MenuItem

@Composable
fun DrawerHeader () {

    // Cabecera del menú lateral
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text (
            text = "Menú",
            fontSize = 24.sp
        )
    }
}
@Composable
fun DrawerBody (
    items: List<MenuItem>,
    onItemClick: (MenuItem)-> Unit
) {
    // Estructura de las opciones del menú
    items.forEach { opcion ->
        NavigationDrawerItem (
            modifier = Modifier
                .padding(start = 20.dp),
            label = { OpcionMenu (opcion.nombre) },
            selected = false,
            onClick = { onItemClick (opcion) }
        )
    }
}
@Composable
fun OpcionMenu (texto: String) {
    Text (
        text = texto,
        fontSize = 18.sp
    )
}
@Composable
fun Imagen (imagen: Int, fraccion: Float) {
    Image (
        modifier = Modifier
            .fillMaxWidth(fraccion),
        painter = painterResource(id = imagen),
        contentDescription = ""
    )
}
@Composable
fun Titulo (texto: String) {
    Text (
        text = texto,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        lineHeight = 35.sp
    )
}
@Composable
fun Texto (texto: String, negritas: Boolean) {
    Text (
        modifier = Modifier
            .fillMaxWidth(),
        text = texto,
        fontSize = 18.sp,
        fontWeight = if(negritas) FontWeight.Bold else FontWeight.Normal
    )
}
@Composable
fun FilaDatos (etiqueta: String, dato: String) {
    Row (verticalAlignment = Alignment.CenterVertically){
        Text (
            modifier = Modifier
                .padding(end = 10.dp)
                .weight(1f),
            text = etiqueta,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text (
            modifier = Modifier.weight(1f),
            text = dato,
            fontSize = 20.sp
        )
    }
}
@Composable
fun EntradaNumerica (label: String, entrada: MutableDoubleState) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        value = text,
        onValueChange = {
            text = it
            entrada.doubleValue = it.toDouble()
        },
        label = { Text (text = label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
    )
}
@Composable
fun BotonPrimario (
    texto: String,
    fillWidth: Boolean,
    onClick: () -> Unit
) {
    Button (
        modifier = Modifier
            .fillMaxWidth(if (fillWidth) 1f else 0.5f)
            .padding(vertical = 10.dp),
        onClick = { onClick() }
    ) {
        Text (text = texto, fontSize = 18.sp)
    }
}
@Composable
fun BotonSecundario (
    texto: String,
    fillWidth: Boolean,
    onClick: () -> Unit
) {
    OutlinedButton (
        modifier = Modifier
            .fillMaxWidth(if (fillWidth) 1f else 0.5f)
            .padding(vertical = 10.dp),
        onClick = { onClick() }
    ) {
        Text (text = texto, fontSize = 18.sp)
    }
}