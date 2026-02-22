package com.nexo.app.nexo.model.datasource

import com.nexo.app.nexo.model.dto.UserDTO

class DataSource {
    //Funcion basica de registro o login
    interface  UserRemoteDataSource {
        suspend fun registerUser(user: UserDTO): Result<UserDTO>
        
    }
}