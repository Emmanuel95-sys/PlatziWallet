package com.cristianvillamil.platziwallet.ui.commands

import android.content.Context
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader

class ReadCommand : FileCommand{
    override fun execute(context: Context, fileName: String, vararg arguments: String) {
        //escribir en la consola lo que vamos a leer de los archivos
        //vamos a hacerlo por medio de un string.
        var fileString = ""

        //abrir conexion con el sistema de archivos para lectura
        //abrir un archivo
        val inputStream = context.openFileInput(fileName)

        //vamos a ir haciendole append a cada uno de los strings que vamos leyendo
        //de nuestro archivo
        val stringBuilder = StringBuilder()

        //leera el archivo
        val inputStreamReader = InputStreamReader(inputStream)

        //permitir leer linea por linea al archivo
        val bufferedReader = BufferedReader(inputStreamReader)

        //por cada linea vamos a agregar un salto de linea con \n (backslash ALT +92)
        //despues del salto de linea hacemos append de la linea (it viene for each line)
        bufferedReader.forEachLine { stringBuilder.append("\n").append(it)}

        //tenemos hasta este punto un stringBuilder
        //tenemos que  pasarlo a string
        fileString = stringBuilder.toString()

        //escribir en consola
        Log.e("ReadedFile", fileString)

    }
}