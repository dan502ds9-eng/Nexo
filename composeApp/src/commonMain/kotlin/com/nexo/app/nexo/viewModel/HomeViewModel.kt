package com.nexo.app.nexo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexo.app.nexo.model.dto.CuentaDTO
import com.nexo.app.nexo.model.repository.CuentaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CuentaRepository): ViewModel(){

    // Estado con la lista de cuentas
    private val _cuentas = MutableStateFlow<List<CuentaDTO>>(emptyList())
    val cuentas: StateFlow<List<CuentaDTO>> = _cuentas

    fun cargarCuentas(idUsuario: Int) {
        viewModelScope.launch {
            val lista = repository.listarMisCuentas(idUsuario)
            _cuentas.value = lista
        }
    }
}