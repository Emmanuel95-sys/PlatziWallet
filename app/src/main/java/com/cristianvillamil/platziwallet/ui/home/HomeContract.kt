package com.cristianvillamil.platziwallet.ui.home

import androidx.lifecycle.LiveData

interface HomeContract {

    interface View{
        //definir funciones de la vista y presentador respecctivametne
        fun showLoader()
        fun hideLoader()
        fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>)

    }

    interface Presenter{
        fun retrieveFavoriteTransfers()
        fun getPercentageLiveData() : LiveData<String>

    }
    //callback que devuelve los datos que estan entre el presentaodr y la capa de datos
    interface OnResponseCallback{
        fun onResponse(favoriteList: List<FavoriteTransfer>)
    }

}