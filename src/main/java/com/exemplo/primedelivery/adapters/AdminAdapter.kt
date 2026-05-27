package com.exemplo.primedelivery.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exemplo.primedelivery.R
import com.exemplo.primedelivery.database.PedidoEntity

class AdminAdapter : RecyclerView.Adapter<AdminAdapter.ViewHolder>() {

    private var lista = listOf<PedidoEntity>()

    fun atualizarLista(novaLista: List<PedidoEntity>) {
        lista = novaLista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pedido_admin, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount() = lista.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvInfo: TextView = itemView.findViewById(R.id.tvInfo)
        private val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)

        fun bind(pedido: PedidoEntity) {
            tvInfo.text = "👤 ${pedido.clienteNome}\n🍔 ${pedido.descricao}\n📍 ${pedido.endereco}"
            val statusText = if (pedido.status == "pendente") "⏳ Pendente" else "✅ Entregue"
            tvStatus.text = statusText
        }
    }
}