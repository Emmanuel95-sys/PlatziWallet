package com.cristianvillamil.platziwallet.ui.commands

import android.content.Context
import android.util.Log
import java.io.IOException
import java.io.OutputStreamWriter

class SaveCommand : FileCommand {

    override fun execute(context: Context, fileName: String, vararg arguments: String) {
        try {
            //obtener cada uno de los argumentos y agregarlo como tal en el contenido
            var argumentsString = ""
            arguments.forEach { argumentsString = argumentsString + "\n" + it }
            //crear un punte tener la clase y poder escribir en memoria.
            val outputStreamWriter = OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE))
            outputStreamWriter.write(argumentsString)
            outputStreamWriter.close()
        }catch (e: IOException){
            Log.e("SaveCommand", "File write failed: $e")
        }

    }
}