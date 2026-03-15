package com.logiclick.wms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogiClickApp()
        }
    }
}

@Composable
fun LogiClickApp() {

    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0B1220),
                        Color(0xFF15253E)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Top
        ) {

            Text(
                text = "LogiClick",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Gestión inteligente de almacén",
                color = Color.LightGray
            )

            Spacer(modifier = Modifier.height(30.dp))

            AnimatedVisibility(
                visible = visible,
                enter = slideInHorizontally { it } + fadeIn()
            ) {

                Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {

                    MenuButton("Entradas", Icons.Default.LocalShipping)
                    MenuButton("Pickings", Icons.Default.Inventory)
                    MenuButton("Zona intercambio", Icons.Default.SwapHoriz)
                    MenuButton("Crear etiquetas", Icons.Default.QrCode)
                    MenuButton("Visión almacén", Icons.Default.Map)

                }
            }
        }
    }
}

@Composable
fun MenuButton(text: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable { },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1F304F)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(15.dp))

            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}