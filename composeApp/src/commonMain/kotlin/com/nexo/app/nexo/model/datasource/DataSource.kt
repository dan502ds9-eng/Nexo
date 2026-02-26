package com.nexo.app.nexo.model.datasource

import com.nexo.app.nexo.model.dto.ApartadoDTO
import com.nexo.app.nexo.model.dto.MovimientoDTO
import com.nexo.app.nexo.model.dto.UserDTO

class DataSource {
    //Funcion basica de registro o login
    interface  UserRemoteDataSource {
        suspend fun validarCorreo(correo: String): Boolean
        suspend fun save(user: UserDTO): Boolean
        suspend fun registerUser(user: UserDTO): Result<UserDTO>
        suspend fun guardarMovimiento(gasto: MovimientoDTO)
        suspend fun guardarApartado(apartado: ApartadoDTO)
        
    }
}