package com.cristianvillamil.platziwallet.ui.observable

interface Observable {
    //suscribir y desuscribir observer
    fun addObserver(observer: CustomObserver)
    fun removeObserver(observer: CustomObserver)
    //notifica un cambio por medio de este metodo
    fun notifyObservers(newValue: Double)
}