package com.exemplo.primedelivery.fragments  // ← Pacote/endereço

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.exemplo.primedelivery.R
import kotlinx.coroutines.*

// 👇 ESTA É A CLASSE (começa com "class" e o nome)
class EntregadorFragment : Fragment() {

    private lateinit var txtEntregas: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Conecta com o arquivo XML
        return inflater.inflate(R.layout.fragment_entregador, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Encontra os elementos do XML
        txtEntregas = view.findViewById(R.id.txtEntregas)
        val btnAtualizar = view.findViewById<Button>(R.id.btnAtualizar)

        // O que acontece quando clica no botão
        btnAtualizar.setOnClickListener {
            carregarEntregas()
        }

        // Carrega os dados quando abre a tela
        carregarEntregas()
    }

    private fun carregarEntregas() {
        // Mostra mensagem de carregamento
        txtEntregas.text = "🔄 Buscando entregas..."

        // Simula tempo de internet (1 segundo)
        CoroutineScope(Dispatchers.Main).launch {
            delay(1000)
            txtEntregas.text = "📦 Você tem 3 entregas disponíveis!\n\n1. Rua das Flores, 123\n2. Av. Principal, 456\n3. Praça Central, 789"
        }
    }
}