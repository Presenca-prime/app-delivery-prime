package com.exemplo.primedelivery

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.exemplo.primedelivery.fragments.AdminFragment
import com.exemplo.primedelivery.fragments.ClienteFragment
import com.exemplo.primedelivery.fragments.EntregadorFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontrar os botões pelo ID
        val btnCliente = findViewById<Button>(R.id.btnCliente)
        val btnEntregador = findViewById<Button>(R.id.btnEntregador)
        val btnAdmin = findViewById<Button>(R.id.btnAdmin)

        // Carregar o fragmento do Cliente ao iniciar
        if (savedInstanceState == null) {
            carregarFragmento(ClienteFragment())
            mudarCorBotao(btnCliente, btnEntregador, btnAdmin, btnCliente)
        }

        // O que acontece quando clica no botão Cliente
        btnCliente.setOnClickListener {
            carregarFragmento(ClienteFragment())
            mudarCorBotao(btnCliente, btnEntregador, btnAdmin, btnCliente)
        }

        // O que acontece quando clica no botão Entregador
        btnEntregador.setOnClickListener {
            carregarFragmento(EntregadorFragment())
            mudarCorBotao(btnCliente, btnEntregador, btnAdmin, btnEntregador)
        }

        // O que acontece quando clica no botão Admin
        btnAdmin.setOnClickListener {
            carregarFragmento(AdminFragment())
            mudarCorBotao(btnCliente, btnEntregador, btnAdmin, btnAdmin)
        }
    }

    private fun carregarFragmento(fragmento: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragmento)
            .commit()
    }

    private fun mudarCorBotao(
        btnCliente: Button,
        btnEntregador: Button,
        btnAdmin: Button,
        botaoSelecionado: Button
    ) {
        // Resetar todos os botões para cinza
        btnCliente.setBackgroundColor(ContextCompat.getColor(this, R.color.gray_dark))
        btnEntregador.setBackgroundColor(ContextCompat.getColor(this, R.color.gray_dark))
        btnAdmin.setBackgroundColor(ContextCompat.getColor(this, R.color.gray_dark))

        // Mudar cor do botão selecionado para vermelho
        botaoSelecionado.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500))
    }
}