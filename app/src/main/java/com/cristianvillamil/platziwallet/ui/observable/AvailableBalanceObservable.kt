package com.cristianvillamil.platziwallet.ui.observable

class AvailableBalanceObservable : Observable {

    private val amountObserverList : ArrayList<CustomObserver> = arrayListOf()
    private var amount: Double = 0.0
//notificamos cada vez que hay un cambio
    //vamos a obtener ese valor de manera reactiva
    fun changeAmount(newValue: Double){
        amount = newValue
        notifyObservers(amount)
    }

    override fun addObserver(observer: CustomObserver) {
        amountObserverList.add(observer)

    }
//me puedo desuscribir en el onDestroy.
    override fun removeObserver(observer: CustomObserver) {
        amountObserverList.remove(observer)

    }

    override fun notifyObservers(newValue: Double) {
        ///notificando a todos los observers
        amountObserverList.forEach {
            it.notifyChange(newValue)
        }
    }

}