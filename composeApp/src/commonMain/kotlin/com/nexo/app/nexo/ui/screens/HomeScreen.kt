package com.nexo.app.nexo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nexo.app.nexo.viewModel.HomeViewModel
import androidx.compose.runtime.getValue

@Composable

fun HomeScreen(viewModel: HomeViewModel) {
    val cuentas by viewModel.cuentas.collectAsState()

    // Llamamos a cargar datos al iniciar
    LaunchedEffect(Unit) {
        viewModel.cargarCuentas(idUsuario = 1)
    }

    Column (modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Mis Cuentas", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(cuentas) { cuenta ->
                Card  (
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Row  (
                        modifier = Modifier.padding(16.dp).fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(cuenta.nombreCuenta, fontWeight = FontWeight.Bold)
                            Text(cuenta.tipoCuenta, style = MaterialTheme.typography.bodySmall)
                        }
                        Text("$${cuenta.saldo}", color = Color(0xFF4CAF50))
                    }
                }
            }
        }
    }
}