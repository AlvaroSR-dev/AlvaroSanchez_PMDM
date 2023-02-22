package com.example.trabajonotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var editTextNombre : EditText
    private lateinit var editTextApellido : EditText
    private lateinit var buttonIniciar : Button
    lateinit var nombre : String
    lateinit var apellido : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        buttonIniciar.setOnClickListener(){
            if (editTextNombre.text.equals(null) || editTextApellido.text.equals(null)){
                val snack = Snackbar.make(it,"Falta un dato",Snackbar.LENGTH_LONG)
                snack.show()
            }else{
                nombre = editTextNombre.text.toString()
                apellido = editTextApellido.text.toString()
                val snack = Snackbar.make(it,"Bienvenido $nombre $apellido",Snackbar.LENGTH_LONG)
                snack.show()
            }
        }
    }

    private fun instancias() {
        editTextNombre = findViewById(R.id.editTextNombre)
        editTextApellido = findViewById(R.id.editTextApellido)
        buttonIniciar = findViewById(R.id.buttonIniciar)
    }
}