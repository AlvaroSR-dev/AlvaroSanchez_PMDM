package com.example.hobbies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorRecyclerView(val lista: List<Elemento>, val onItemClickListener: (Elemento) -> Unit) : RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imagen = view.findViewById<ImageView>(R.id.imageViewIcono)
        val nombre = view.findViewById<TextView>(R.id.textViewNombre)
        val detalle = view.findViewById<TextView>(R.id.textViewDetalle)

        fun bind(elemento: Elemento, onItemClickListener: (Elemento) -> Unit) {
            nombre.text = elemento.nombre
            detalle.text = elemento.detalle
            imagen.setImageResource(elemento.imagen)
            itemView.setOnClickListener{onItemClickListener(elemento)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val elemento = lista[position]
        holder.bind(elemento, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}