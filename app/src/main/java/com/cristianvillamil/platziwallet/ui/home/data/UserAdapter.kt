package com.cristianvillamil.platziwallet.ui.home.data

import com.cristianvillamil.platziwallet.ui.home.view.UserViewModel

class UserAdapter() {
    //recibir user response y retornar el view model
    //adaptando el contenido del response hacia el contenido que necesita la vista
    //dado un user response vamos a obtener un user viewmodel
    //es comun que las respuestas entre los responses cambien
    fun getUserBiewModel(userResponse: UserResponse) : UserViewModel{
        return  UserViewModel(userResponse.name, userResponse.userPhotoURL)
    }
}