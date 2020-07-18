package com.cristianvillamil.platziwallet.ui.home.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor
import com.cristianvillamil.platziwallet.ui.home.data.User

class HomePresenter(private val view : HomeContract.View) : HomeContract.Presenter {

    private val homeInteractor : HomeInteractor = HomeInteractor()
    //live data va a cambiar en tiempo de ejecucion
    private val percentageliveData : MutableLiveData<String> = MutableLiveData()

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
                //mutable live data nos permite cambiar el valor del objeto
                percentageliveData.value = "40%"
                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }
        })
    }
    //al solicitarle al presentador el mutable live data
    //le tenemos que dar un live data que no sea mutable
    //encapsulamiento
    //garantia de que cuadno se lo solicitemos al presentador
    //nosotros vamos a recibir una instancia de LiveData
    override fun getPercentageLiveData() : LiveData<String> = percentageliveData

}