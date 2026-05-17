package com.exemplo.primedelivery.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.exemplo.primedelivery.R
import kotlinx.coroutines.*

class ClienteFragment : Fragment() {

    private lateinit var txtRespostaApi: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Isso conecta o código com o arquivo XML que você criou
        return inflater.inflate(R.layout.fragment_cliente, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Encontrar os botões e textos do XML pelo ID
        txtRespostaApi = view.findViewById(R.id.txtRespostaApi)
        val btnPedido = view.findViewById<Button>(R.id.btnFazerPedido)

        // O que acontece quando clica no botão
        btnPedido.setOnClickListener {
            fazerPedido()
        }

        // Carregar dados quando abrir a tela
        carregarDadosDaApi()
    }

    private fun carregarDadosDaApi() {
        txtRespostaApi.text = "🔄 Carregando dados da API..."

        // Simula uma espera de 1.5 segundos (igual internet)
        CoroutineScope(Dispatchers.Main).launch {
            delay(1500)
            txtRespostaApi.text = "✅ API funcionando! Seu pedido está pronto!"
        }
    }

    private fun fazerPedido() {
        txtRespostaApi.text = "🛵 Pedido enviado! Aguarde o entregador..."
    }
}