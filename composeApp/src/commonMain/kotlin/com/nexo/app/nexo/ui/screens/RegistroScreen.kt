package com.nexo.app.nexo.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexo.app.nexo.viewModel.RegistroViewModel


@Composable
fun RegistroScreen(viewModel: RegistroViewModel){
    //Variables para guardar lo que el usuario escribe
    var nombre by remember { mutableStateOf("") }
    var correo by remember {mutableStateOf("") }
    var pin by remember {mutableStateOf("") }
    //Observamos el estado del registro desde el ViewModel
    val registroExitoso by viewModel.registroExitoso.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Text (text = "Crear Cuenta Nexo", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it },
            label = { Text ("Nombre Completo: ") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = correo,
            onValueChange = { correo  = it },
            label = { Text ("Correo Electrónico:  ") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = pin,
            onValueChange = { pin  = it },
            label = { Text ("PIN de Acceso:  ") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {viewModel.registrarUsuario(nombre, correo, pin)},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarme")
        }

        //Mostrar un mensaje si el registro fue exitoso
        if (registroExitoso == true) {
            Text("¡Registro exitoso!", color = androidx.compose.ui.graphics.Color.Green)
        }



    }

}