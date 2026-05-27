package com.exemplo.primedelivery.activities

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exemplo.primedelivery.R
import com.exemplo.primedelivery.adapters.AdminAdapter
import com.exemplo.primedelivery.database.AppDatabase
import kotlinx.coroutines.launch

class AdminActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var adapter: AdminAdapter
    private lateinit var tvTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        db = AppDatabase.getInstance(this)

        tvTotal = findViewById(R.id.tvTotal)
        val rvPedidos = findViewById<RecyclerView>(R.id.rvPedidos)
        rvPedidos.layoutManager = LinearLayoutManager(this)

        adapter = AdminAdapter()
        rvPedidos.adapter = adapter

        carregarDados()

        findViewById<Button>(R.id.btnVoltar).setOnClickListener {
            finish()
        }
    }

    private fun carregarDados() {
        lifecycleScope.launch {
            db.pedidoDao().buscarTodos().collect { pedidos ->
                adapter.atualizarLista(pedidos)
                val pendentes = pedidos.count { it.status == "pendente" }
                val entregues = pedidos.count { it.status == "entregue" }
                tvTotal.text = "📊 Total: ${pedidos.size} | Pendentes: $pendentes | Entregues: $entregues"
            }
        }
    }
}