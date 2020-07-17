package com.cristianvillamil.platziwallet.ui.home.presenter

import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor
import com.cristianvillamil.platziwallet.ui.home.data.User

class HomePresenter(private val view : HomeContract.View) : HomeContract.Presenter {

    private val homeInteractor : HomeInteractor = HomeInteractor()

    override fun retrieveFavoriteTransfers(){
        view.showLoader()
        homeInteractor.retrieveFavoriteTransfersFromCache(object : HomeContract.OnResponseCallback{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {
                //en el momento en que el presentador haga un cambio
                //
                UserSingleton.getInstance().userName = "Dato modificado"
                //eso no es lo que queremos
                //la idea es que usemos siempre el builder
                //para ograrlo declaramos el constructor privado
//                val user = User("Emmanuel", "1253")
               //puedo crear un user sin contraseña por que el parametro es ocpional
                val user = User.Builder()
                    .setUserName("Emmanuel")
                    .build()

                val user2 = User.Builder()
                    .setUserName("Sarahi")
                    .setPassword("4sgd561gd")
                    .build()
                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }
        })
    }
}