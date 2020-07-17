package com.cristianvillamil.platziwallet.ui.home.data

class User private  constructor(private val userName: String,private val password: String) {
    //gestiona parametros opcionales
    class Builder {
        var userName: String = ""
        var password: String? = null

        //parametros y funciones
        //donde vamos a sobreescribir los parametros del constructor del usuario
        //tener en cuenta que vamos a seguir retornando la clase builder
        //vaos a construir progrevisamente y ocn parametros opcionales
        fun setUserName(newUserName : String ) : Builder{
            this.userName = newUserName
            return this
        }
        //al momento de hacer el set username puedo seguir editando
        //los otros parametros
        fun setPassword(newPassword: String): Builder{
            this.password = newPassword
            return this
        }

        //este metodo se encarga de crear la instancia de user
        fun build(): User{
            //el builder puede encargarse de setear un valor por defecto
            //si password es nule le pasamos un "
            return User(userName, password ?: "")
        }
    }
}