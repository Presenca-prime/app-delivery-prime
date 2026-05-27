package com.exemplo.primedelivery.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PedidoDao {

    @Insert
    suspend fun inserir(pedido: PedidoEntity)

    @Update
    suspend fun atualizar(pedido: PedidoEntity)

    @Delete
    suspend fun deletar(pedido: PedidoEntity)

    @Query("SELECT * FROM pedidos ORDER BY id DESC")
    fun buscarTodos(): Flow<List<PedidoEntity>>

    @Query("SELECT * FROM pedidos WHERE status = :status")
    fun buscarPorStatus(status: String): Flow<List<PedidoEntity>>
}