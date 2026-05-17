package com.exemplo.primedelivery.api

import retrofit2.http.GET
import retrofit2.http.Query

// Interface da API (contrato das requisições)
interface ApiService {

    @GET("posts/1")
    suspend fun getMensagem(): PostResposta

    @GET("posts")
    suspend fun getPedidos(@Query("userId") usuarioId: Int): List<PostResposta>
}

// Modelo de dados para as respostas da API
data class PostResposta(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)