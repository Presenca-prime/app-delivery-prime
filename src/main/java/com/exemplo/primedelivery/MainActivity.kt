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

        val btnCliente = findViewById<Button>(R.id.btnCliente)
        val btnEntregador = findViewById<Button>(R.id.btnEntregador)
        val btnAdmin = findViewById<Button>(R.id.btnAdmin)

        if (savedInstanceState == null) {
            carregarFragmento(ClienteFragment())
            mudarCorBotao(btnCliente, btnEntregador, btnAdmin, btnCliente)
        }

        btnCliente.setOnClickListener {
            carregarFragmento(ClienteFragment())
            mudarCorBotao(btnCliente, btnEntregador, btnAdmin, btnCliente)
        }

        btnEntregador.setOnClickListener {
            carregarFragmento(EntregadorFragment())
            mudarCorBotao(btnCliente, btnEntregador, btnAdmin, btnEntregador)
        }

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
        btnCliente.setBackgroundColor(ContextCompat.getColor(this, R.color.gray_dark))
        btnEntregador.setBackgroundColor(ContextCompat.getColor(this, R.color.gray_dark))
        btnAdmin.setBackgroundColor(ContextCompat.getColor(this, R.color.gray_dark))
        botaoSelecionado.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500))
    }
}