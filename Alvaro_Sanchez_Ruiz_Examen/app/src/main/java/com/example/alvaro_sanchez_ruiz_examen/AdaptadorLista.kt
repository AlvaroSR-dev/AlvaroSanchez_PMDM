package com.example.alvaro_sanchez_ruiz_examen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorLista(var lista: List<Coche>, var context: Context): BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(p0: Int): Any {
        return lista.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = p1?: LayoutInflater.from(context).inflate(R.layout.vista_coche, p2,false)
        val imagenCoche = view.findViewById<ImageView>(R.id.imageViewCoche)
        val nombre = view.findViewById<TextView>(R.id.textViewNombre)
        val imagenEtiqueta = view.findViewById<ImageView>(R.id.imageViewEtiqueta)
        imagenCoche.setImageResource(lista[p0].imagen)
        nombre.text = lista[p0].nombre
        imagenEtiqueta.setImageResource(lista[p0].etiqueta)
        return view
    }


}