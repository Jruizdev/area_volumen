package com.example.areavolumen_joro.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior (titulo: String, onClick: () -> Unit) {
    TopAppBar (
        title = { Text (text = titulo) },
        navigationIcon = {
            IconButton( onClick = { onClick () }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menú")
            }
        }
    )
}