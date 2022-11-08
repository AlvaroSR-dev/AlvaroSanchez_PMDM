package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editTextResultado : EditText
    private lateinit var buttonCero : Button
    private lateinit var buttonUno : Button
    private lateinit var buttonDos : Button
    private lateinit var buttonTres : Button
    private lateinit var buttonCuatro : Button
    private lateinit var buttonCinco : Button
    private lateinit var buttonSeis : Button
    private lateinit var buttonSiete : Button
    private lateinit var buttonOcho : Button
    private lateinit var buttonNueve : Button
    private var arrayNumeros : Array<Int> = arrayOf(R.id.buttonCero, R.id.buttonUno, R.id.buttonDos, R.id.buttonTres, R.id.buttonCuatro, R.id.buttonCinco, R.id.buttonSeis, R.id.buttonSiete, R.id.buttonOcho, R.id.buttonNueve)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        buttonUno.setOnClickListener(){
            editTextResultado.setText(buttonUno.text)
        }

        arrayNumeros.forEach {

        }
    }

    private fun instancias() {
        editTextResultado = this.findViewById(R.id.editTextResultado)
        buttonCero = this.findViewById(R.id.buttonCero)
        buttonUno = this.findViewById(R.id.buttonUno)
        buttonDos = this.findViewById(R.id.buttonDos)
        buttonTres = this.findViewById(R.id.buttonTres)
        buttonCuatro = this.findViewById(R.id.buttonCuatro)
        buttonCinco = this.findViewById(R.id.buttonCinco)
        buttonSeis = this.findViewById(R.id.buttonSeis)
        buttonSiete = this.findViewById(R.id.buttonSiete)
        buttonOcho = this.findViewById(R.id.buttonOcho)
        buttonNueve = this.findViewById(R.id.buttonNueve)
    }
}