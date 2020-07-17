package com.cristianvillamil.platziwallet

class UserSingleton {
    var userName = "Emmanuel"
    //variables estaticas
    companion object{
        private var instance: UserSingleton? = null
//        val userName = "Emmanuel"

        fun getInstance() : UserSingleton{
            if(instance == null){
                instance = UserSingleton()
            }
            return instance as UserSingleton
        }
    }
}