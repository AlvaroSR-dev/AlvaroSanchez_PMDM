package com.example.alvaro_sanchez_ruiz_examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Modelos : AppCompatActivity() {
    private lateinit var listaCoches: ArrayList<Coche>
    private lateinit var listViewCoches: ListView
    private lateinit var adaptadorLenguajesLista: AdaptadorLista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modelos)
        listViewCoches = findViewById(R.id.listViewCoches)
        llenarLista()
        calcularEtiquetas()
        mostrarLista()
        mostrarAnio()
    }

    private fun llenarLista() {
        listaCoches = ArrayList();
        listaCoches.add(Coche("Arteon", "Volkswagen", 2016, "Hibrido", R.drawable.arteon))
        listaCoches.add(Coche("Astra", "Opel", 2012, "Diesel", R.drawable.astra))
        listaCoches.add(Coche("Cordoba", "Seat", 2004, "Dielesel", R.drawable.cordoba))
        listaCoches.add(Coche("Corsa", "Opel", 2016, "Hibrido", R.drawable.corsa))
        listaCoches.add(Coche("Golf", "Volkswagen", 2012, "Gasolina", R.drawable.golf))
        listaCoches.add(Coche("Ibiza", "Seat", 2021, "Dielesel", R.drawable.ibiza))
        listaCoches.add(Coche("Leon", "Seat", 2019, "Gasolina", R.drawable.leon))
        listaCoches.add(Coche("Tiguan", "Volkswagen", 2015, "Electrico", R.drawable.tiguan))
    }

    private fun calcularEtiquetas() {
        for (coche : Coche in listaCoches){
            coche.calcularEtiqueta()
        }
    }

    private fun mostrarLista() {
        adaptadorLenguajesLista = AdaptadorLista(listaCoches,this)
        listViewCoches.adapter = adaptadorLenguajesLista
    }

    private fun mostrarAnio(){
        listViewCoches.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(applicationContext, listaCoches[position].nombre, Toast.LENGTH_SHORT).show()
        }
    }
}