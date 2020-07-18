package com.cristianvillamil.platziwallet.ui.commands

import android.content.Context

interface FileCommand {
    //cada comando que utilicemos en el proyecto
    //sera implementando esta interfaz
    //con esto caudno el command manager me retorne un comando
    //nosotros simplemente vamos a darle execute
    //y el lo va a ejecutar
    fun execute(context: Context, fileName: String, vararg arguments : String )
}