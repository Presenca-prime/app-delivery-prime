package com.exemplo.primedelivery.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.exemplo.primedelivery.R
import com.exemplo.primedelivery.activities.EntregasActivity

class EntregadorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_entregador, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAtualizar = view.findViewById<Button>(R.id.btnAtualizar)

        btnAtualizar.setOnClickListener {
            val intent = Intent(requireContext(), EntregasActivity::class.java)
            startActivity(intent)
        }
    }
}