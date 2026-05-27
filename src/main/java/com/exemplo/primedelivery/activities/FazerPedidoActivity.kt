package com.exemplo.primedelivery.activities

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.exemplo.primedelivery.R
import com.exemplo.primedelivery.database.AppDatabase
import com.exemplo.primedelivery.database.PedidoEntity
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.launch

class FazerPedidoActivity : AppCompatActivity() {

    private lateinit var etNome: TextInputEditText
    private lateinit var etDescricao: TextInputEditText
    private lateinit var etEndereco: TextInputEditText
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fazer_pedido)

        db = AppDatabase.getInstance(this)

        etNome = findViewById(R.id.etNome)
        etDescricao = findViewById(R.id.etDescricao)
        etEndereco = findViewById(R.id.etEndereco)

        findViewById<Button>(R.id.btnSalvarPedido).setOnClickListener {
            salvarPedido()
        }

        findViewById<Button>(R.id.btnVoltar).setOnClickListener {
            finish()
        }
    }

    private fun salvarPedido() {
        val nome = etNome.text.toString()
        val descricao = etDescricao.text.toString()
        val endereco = etEndereco.text.toString()

        if (nome.isEmpty() || descricao.isEmpty() || endereco.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            return
        }

        lifecycleScope.launch {
            val pedido = PedidoEntity(
                clienteNome = nome,
                descricao = descricao,
                endereco = endereco,
                status = "pendente"
            )
            db.pedidoDao().inserir(pedido)
            Toast.makeText(this@FazerPedidoActivity, "✅ Pedido realizado com sucesso!", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}