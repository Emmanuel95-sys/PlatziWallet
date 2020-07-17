package com.cristianvillamil.platziwallet.ui.home.presenter

import com.cristianvillamil.platziwallet.UserSingleton
import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor

class HomePresenter(private val view : HomeContract.View) : HomeContract.Presenter {

    private val homeInteractor : HomeInteractor = HomeInteractor()

    override fun retrieveFavoriteTransfers(){
        view.showLoader()
        homeInteractor.retrieveFavoriteTransfersFromCache(object : HomeContract.OnResponseCallback{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {
                //en el momento en que el presentador haga un cambio
                //
                UserSingleton.getInstance().userName = "Dato modificado"

                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }
        })
    }
}