package com.cristianvillamil.platziwallet.ui.transfer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//para decirle que el applicationDatabase es un ROOM database
//vamos a usar una anotacion especificando cuales entidades hacen parte
//
@Database(entities = [TransferEntity::class], version = 1)
abstract class ApplicationDataBase : RoomDatabase(){

    abstract  fun getDAO() : TransfersDAO

    companion object{
        //en un valor inicial no tenemos la conexion
        private var INSTANCE : ApplicationDataBase? = null

        //crear instancia unica de la base de datos

        fun getAppDataBase(context: Context) : ApplicationDataBase? {
            //implementando un singleton
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ApplicationDataBase::class.java,
                    "platziWalletDatabase"
                ).allowMainThreadQueries()
                    .build()
            }
        return INSTANCE
        }

        //borrar la instancia de la base de datos

        fun destroyInstance(){
            INSTANCE = null
        }
    }

}