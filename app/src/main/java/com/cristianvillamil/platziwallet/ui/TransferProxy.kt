package com.cristianvillamil.platziwallet.ui

class TransferProxy {

    val MAX_TRANSFER_AMOUNT = 1000000
    val MIN_TRANSFER_AMOUNT = 100

    fun checkTransfer(amount: Double) : String{
        return when{
            amount > MAX_TRANSFER_AMOUNT -> {
                "La transaccion excede el monto maximo"
            }
            amount < MIN_TRANSFER_AMOUNT -> {
                "La transferencia de ser mayor $MIN_TRANSFER_AMOUNT"
            }
            else -> {
                doTransfer(amount)
                "La transferencia cumple con las reglas de negocio"

            }
        }
    }

    //aqui ya tenemos la certeza de que las reglas dde negocio se umplen
    private fun doTransfer(amount: Double){


    }

}