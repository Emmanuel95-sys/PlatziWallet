package com.cristianvillamil.platziwallet.ui.observable


//va a notificar todos los eventos del observable
interface CustomObserver {
    //el valor que teniamos anterioirmente cambio
    //observer tendra un callback que va a notificar el cambio
    fun notifyChange(newValue: Double)

}