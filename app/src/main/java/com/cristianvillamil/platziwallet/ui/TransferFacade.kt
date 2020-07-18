package com.cristianvillamil.platziwallet.ui

import com.cristianvillamil.platziwallet.ui.transfer.TransferManager

//nos ayud a encapsular todos los subsistemas
//los sistemas de analitycs y Security en una aplaicion del muno d¿real son muy complejas
//
class TransferFacade(){
    //Facade esta encapsulando la complejidad de tres subssitemas
    //en simplemetne un metodo de transfrencia
    //si en dado caso se va a agregar o quitar alguno de los subssitemas
    //la responsabilidad unica la tiene la transferencia
    //cuando nostroso lo llamamos de la vista
    //simplemente la vista va a a llamar al presentador
    //el presentador va a llarma a la fachada y ella se encargara de hacer toda la conexion
    //y va a solucionar la complejidad con todos los subsistemas
    val analyticsManager = AnalyticsManager()
    val securityManager : SecurityManager = SecurityManager()
    val transferManager = TransferManager()

    //METODO DE TRANSFERENCIA
    fun transfer(){
        val token =  securityManager.getToken()
        analyticsManager.registerTransfer(token)
        transferManager.transfer(token)

    }


}