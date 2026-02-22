package com.nexo.app.nexo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexo.app.nexo.model.dto.UserDTO
import com.nexo.app.nexo.model.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegistroViewModel (private val repository: UserRepository) : ViewModel(){

    //Estado para controlar qué ve el USUARIO(cargando, Exito, Error)
    private val _registroExitoso = MutableStateFlow<Boolean?> (null)
    val registroExitoso: StateFlow<Boolean?> = _registroExitoso

    fun registrarUsuario(nombre: String, correo: String, pin: String){
        viewModelScope.launch{
            val nuevoUsuario = UserDTO(
                nombre = nombre,
                correo = correo,
                pinAcceso = pin
            )
            val resultado = repository.crearCuenta(nuevoUsuario.nombre, nuevoUsuario.correo, nuevoUsuario.pinAcceso)
            _registroExitoso.value = resultado.isSuccess
        }
    }
}