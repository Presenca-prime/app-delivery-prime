package com.exemplo.primedelivery.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pedidos")
data class PedidoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val clienteNome: String,
    val descricao: String,
    val endereco: String,
    val status: String
)