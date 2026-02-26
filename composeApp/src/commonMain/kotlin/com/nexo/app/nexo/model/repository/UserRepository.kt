package com.nexo.app.nexo.model.repository

import com.nexo.app.nexo.model.datasource.DataSource
import com.nexo.app.nexo.model.dto.UserDTO

class UserRepository (
    private val dataSource: DataSource.UserRemoteDataSource

){
    suspend fun crearCuenta(nombre: String, correo: String,pinAcceso: String): Result <UserDTO>{
        val newUser = UserDTO(nombre = nombre, correo = correo, pinAcceso = pinAcceso)
        return dataSource.registerUser(newUser)
    }
}