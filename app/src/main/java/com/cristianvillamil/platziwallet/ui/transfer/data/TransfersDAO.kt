package com.cristianvillamil.platziwallet.ui.transfer.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

//DAO Data Access Object
//acceder el objeto
//desde aui podemos definir operaciones CRUD(Create Read Update Delete)
//Rom auto genera clases y va a ejecutar estos metodos
@Dao
interface TransfersDAO {
    @Query("SELECT * FROM transfers")
    fun getAll() : List<TransferEntity>
    @Query("SELECT * FROM transfers WHERE user_name LIKE :userName")
    fun findTransferByUserName(userName: String) : List<TransferEntity>
    @Insert
    fun saveTransfer(transfer: TransferEntity)
    @Delete
    fun deleteTransfer(transfer : TransferEntity)
}