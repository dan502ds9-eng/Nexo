package com.nexo.app.nexo

import androidx.compose.material3.MaterialTheme

//------------------
import androidx.compose.runtime.Composable
import com.nexo.app.nexo.model.datasource.DataSource
import com.nexo.app.nexo.model.dto.UserDTO
import com.nexo.app.nexo.ui.screens.RegistroScreen
import com.nexo.app.nexo.viewModel.RegistroViewModel
import com.nexo.app.nexo.model.repository.UserRepository

@Composable
fun App(){
    MaterialTheme {
        //1.- Instamciamos la cadena de responsabilidades(Temporalmente manual)
        //Sustituir 'UserDataSourceImpl()' por la clase real de datos
        val repository = UserRepository(dataSource = UserDataSourceImpl())
        val registroViewModel = RegistroViewModel(repository = repository)

        //2.- Llamamos a la pantalla y le pasamos el ViewModel
        RegistroScreen(viewModel = registroViewModel)
    }
}

class UserDataSourceImpl : DataSource.UserRemoteDataSource{
    override suspend fun registerUser(user: UserDTO): Result<UserDTO> {
        //Simulando registro siempre exitoso por ahora
        return Result.success(user)
    }
}