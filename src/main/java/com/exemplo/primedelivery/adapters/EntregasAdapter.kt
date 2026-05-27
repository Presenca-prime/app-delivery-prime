package com.exemplo.primedelivery.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exemplo.primedelivery.R
import com.exemplo.primedelivery.database.PedidoEntity

class EntregasAdapter(
    private val onEntregarClick: (PedidoEntity) -> Unit
) : RecyclerView.Adapter<EntregasAdapter.ViewHolder>() {

    private var lista = listOf<PedidoEntity>()

    fun atualizarLista(novaLista: List<PedidoEntity>) {
        lista = novaLista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entrega, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position], onEntregarClick)
    }

    override fun getItemCount() = lista.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCliente: TextView = itemView.findViewById(R.id.tvCliente)
        private val tvDescricao: TextView = itemView.findViewById(R.id.tvDescricao)
        private val tvEndereco: TextView = itemView.findViewById(R.id.tvEndereco)
        private val btnEntregar: Button = itemView.findViewById(R.id.btnEntregar)

        fun bind(pedido: PedidoEntity, onClick: (PedidoEntity) -> Unit) {
            tvCliente.text = "👤 ${pedido.clienteNome}"
            tvDescricao.text = "🍔 ${pedido.descricao}"
            tvEndereco.text = "📍 ${pedido.endereco}"

            btnEntregar.setOnClickListener {
                onClick(pedido)
            }
        }
    }
}