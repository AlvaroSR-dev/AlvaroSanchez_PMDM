package com.example.examen_alvarosr.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_alvarosr.R
import com.example.examen_alvarosr.model.Vuelo
import com.google.android.material.snackbar.Snackbar

class AdaptadorVuelos(var contexto: Context, var listaDatos: List<*>):
    RecyclerView.Adapter<AdaptadorVuelos.MyHolder>() {

    private lateinit var listener: OnVueloListener

    inner class MyHolder (var view: View): RecyclerView.ViewHolder(view) {

        var imageViewIda: ImageView
        var imageViewVuelta: ImageView
        var fechaIda: String
        var fechaVuelta: String
        var buttonDetalle: Button

        init {
            imageViewIda = view.findViewById(R.id.imageViewIda)
            imageViewVuelta = view.findViewById(R.id.imageViewVuelta)
            fechaIda = ""
            fechaVuelta = ""
            buttonDetalle = view.findViewById(R.id.buttonDetalle)
            listener = contexto as OnVueloListener
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.vuelo,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var vuelo: Vuelo = listaDatos.get(position) as Vuelo
        holder.imageViewIda.setImageResource(vuelo.imagenOrigen)
        holder.imageViewVuelta.setImageResource(vuelo.imagenDestino)
        holder.fechaIda = vuelo.ida
        holder.fechaVuelta = vuelo.vuelta

        holder.buttonDetalle.setOnClickListener(){
            Snackbar.make(
                holder.buttonDetalle,
                "Ida: ${holder.fechaIda} | Vuelta: ${holder.fechaVuelta}",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    interface OnVueloListener{
        fun onVueloClick(vuelo: Vuelo)
    }

}