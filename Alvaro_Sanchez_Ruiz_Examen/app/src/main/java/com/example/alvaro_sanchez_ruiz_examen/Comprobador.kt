package com.example.alvaro_sanchez_ruiz_examen

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.alvaro_sanchez_ruiz_examen.databinding.ActivityComprobadorBinding

/*
Pantalla comprobador: pantalla donde se podrá ver la etiqueta asociada a un
modelo concreto. Para ello la pantalla tendrá los siguientes elementos:
    o TextViews que indica el tipo de dato a introducir
    o EditText que permiten introducir el dato. Los tipos de datos que se
    pueden introducir restringidos, es decir que en el año de matriculación
    solo se podrán meter números
    o Spinner donde se podrá seleccionar el tipo de combustible: Diesel,
    Gasolina, Hibrido, Eléctrico
    o Botón que al ser pulsado mostrará la etiqueta del modelo con los datos
    introducidos. En caso de faltar algún dato mostrará un Snackbar de
    aviso
    o Imagen situada en el 50% inferior de la pantalla
    En momento en el que se selecciona en el spinner hibrido se pone como año de
    matriculación 2018 y se deshabilita. En el caso de poner eléctrico el año de
    matriculación se pondrá 2020
 */

class Comprobador : AppCompatActivity() {
    lateinit var binding: ActivityComprobadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComprobadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenarSpinner()
        acciones()
    }

    private fun llenarSpinner() {
        val opciones = arrayOf("Diesel","Gasolina","Hibrido","Electrico")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerOpciones.adapter = adapter
    }

    private fun acciones() {
        binding.buttonComprobar.setOnClickListener(){
            var anioMatriculacion : Int = binding.editTextAnio.text.toString().toInt()
            var combustible : String = binding.spinnerOpciones.selectedItem.toString()
            var coche : Coche = Coche("Coche", "Volkswagen",anioMatriculacion , combustible, 0)
            coche.calcularEtiqueta()
            binding.imageViewComprobar.setImageResource(coche.etiqueta)
        }
    }

}