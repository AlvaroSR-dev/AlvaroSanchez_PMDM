package com.example.cartas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var buttonEmpezar: Button;
    lateinit var editNombre: EditText;
    var nombre: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEmpezar.setOnClickListener() {
            nombre = editNombre.text.toString();
            println(nombre)
        }
    }
}