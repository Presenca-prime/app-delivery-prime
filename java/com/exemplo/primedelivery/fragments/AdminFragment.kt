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

class AdminFragment : Fragment() {

    private lateinit var txtPedidos: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_admin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtPedidos = view.findViewById(R.id.txtPedidos)
        val btnAtualizar = view.findViewById<Button>(R.id.btnAtualizarAdmin)

        btnAtualizar.setOnClickListener {
            atualizarDados()
        }

        atualizarDados()
    }

    private fun atualizarDados() {
        CoroutineScope(Dispatchers.Main).launch {
            txtPedidos.text = "📊 Carregando estatísticas..."
            delay(1000)
            txtPedidos.text = "✅ Total de pedidos hoje: 47\n👥 Clientes ativos: 23\n🛵 Entregadores online: 8"
        }
    }
}