package com.nexo.app.nexo.model.repository

import com.nexo.app.nexo.model.datasource.DataSource
import com.nexo.app.nexo.model.dto.ApartadoDTO
import com.nexo.app.nexo.model.dto.MovimientoDTO
import com.nexo.app.nexo.model.dto.UserDTO

class FinanzasRepository (private val dataSource: DataSource.UserRemoteDataSource) {

    //Función 1: Registro con validación
    @Suppress("SuspiciousIndentation")
    suspend fun registrarUsuario(user: UserDTO): Result<Boolean>{
        //Validar si ya hay un correo asociado
        val existe = dataSource.validarCorreo(user.correo)
            return if(!existe) Result.success(dataSource.save(user))
            else Result.failure(Exception("Correo ya registrado"))
    }
    //Función 4: Registro de Gastos con lógica de validación
    suspend fun registrarGasto(gasto: MovimientoDTO){
        if(!gasto.Esencial){
            //Logica: "Validar gastos no esenciales recurrentes"
            alertarGastoRecurrente(gasto)
        }
        dataSource.guardarMovimiento(gasto)
    }

    private fun alertarGastoRecurrente(gasto: com.nexo.app.nexo.model.dto.MovimientoDTO) {}
    suspend fun guardarApartado(apartado: ApartadoDTO){
        dataSource.guardarApartado(apartado)
    }
}