package com.example.hobbies

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class AdaptadorSpinner(var listaElementos: ArrayList<String>, var contexto: Context) : BaseAdapter(){
    override fun getCount(): Int {
        return listaElementos.size
    }

    override fun getItem(p0: Int): Any {
        return listaElementos.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    fun agregarElemento(elemento: String){
        listaElementos.add(elemento)
        notifyDataSetChanged()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var vista: View =  LayoutInflater.from(contexto).inflate(R.layout.item_spinner,p2,false)

        var palabra: TextView = vista.findViewById(R.id.textViewOpcion)

        var elemento = listaElementos[p0]
        palabra.text = elemento

        return vista
    }
}