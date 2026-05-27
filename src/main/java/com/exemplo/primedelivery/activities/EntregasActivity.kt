package com.exemplo.primedelivery.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exemplo.primedelivery.R
import com.exemplo.primedelivery.adapters.EntregasAdapter
import com.exemplo.primedelivery.database.AppDatabase
import kotlinx.coroutines.launch

class EntregasActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var adapter: EntregasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entregas)

        db = AppDatabase.getInstance(this)

        val rvEntregas = findViewById<RecyclerView>(R.id.rvEntregas)
        rvEntregas.layoutManager = LinearLayoutManager(this)

        adapter = EntregasAdapter { pedido ->
            lifecycleScope.launch {
                val pedidoAtualizado = pedido.copy(status = "entregue")
                db.pedidoDao().atualizar(pedidoAtualizado)
                carregarEntregas()
            }
        }
        rvEntregas.adapter = adapter

        carregarEntregas()

        findViewById<Button>(R.id.btnVoltar).setOnClickListener {
            finish()
        }
    }

    private fun carregarEntregas() {
        lifecycleScope.launch {
            db.pedidoDao().buscarPorStatus("pendente").collect { pedidos ->
                adapter.atualizarLista(pedidos)
            }
        }
    }
}