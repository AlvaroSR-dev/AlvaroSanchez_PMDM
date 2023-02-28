package com.example.practicadialogostrabajadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorTrabajador(var contexto: Context, var listaDatos: List<*>):
    RecyclerView.Adapter<AdaptadorTrabajador.MyHolder>() {
    private lateinit var listener: OnTrabajadorListener

    inner class MyHolder (view: View): RecyclerView.ViewHolder(view) {

        var textViewNombreCompleto: TextView
        var imageViewTrabajador: ImageView
        var correo: String
        var trabajo: String
        var edad: Int

        init {
            textViewNombreCompleto = view.findViewById(R.id.textViewNombreCompleto)
            imageViewTrabajador = view.findViewById(R.id.imageViewTrabajador)
            correo = ""
            trabajo = ""
            edad = 0
            listener = contexto as OnTrabajadorListener
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(contexto).inflate(R.layout.trabajador,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var trabajador: Trabajador = listaDatos[position] as Trabajador
        holder.textViewNombreCompleto.text = "${trabajador.nombre} ${trabajador.apellidos}"
        holder.correo = trabajador.correo
        holder.trabajo = trabajador.trabajo
        holder.edad = trabajador.edad

        // if para establecer una imagen dependiendo del puesto de trabajo

        when (trabajador.trabajo) {
            "Administrativo" -> holder.imageViewTrabajador.setImageResource(R.drawable.administrativo)
            "Comercial" -> holder.imageViewTrabajador.setImageResource(R.drawable.comercial)
            "Soporte" -> holder.imageViewTrabajador.setImageResource(R.drawable.soporte)
            "Informática" -> holder.imageViewTrabajador.setImageResource(R.drawable.informatica)
        }

        // onClickListener para el recycler

        holder.textViewNombreCompleto.setOnClickListener{
            listener.onTrabajadorClick(trabajador)
        }
        holder.imageViewTrabajador.setOnClickListener{
            listener.onTrabajadorClick(trabajador)
        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    // interfaz onClickListener
    interface OnTrabajadorListener{
        fun onTrabajadorClick(trabajador: Trabajador)
    }
}