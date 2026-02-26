package com.nexo.app.nexo.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nexo.app.nexo.model.dto.ApartadoDTO
import com.nexo.app.nexo.model.repository.FinanzasRepository
import kotlinx.coroutines.launch

class FuncionesViewModel(private val repository: FinanzasRepository): ViewModel() {

    //Función 6: Hacer apartados

    fun crearApartado(nombre: String, meta: Double, fecha: String){
        viewModelScope.launch {
            val nuevoApartado = ApartadoDTO(nombre, meta, fecha)
            repository.guardarApartado(nuevoApartado)
        }
    }
}