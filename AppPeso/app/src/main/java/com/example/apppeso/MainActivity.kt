package com.example.apppeso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var peso: TextView;
    lateinit var altura: TextView;
    lateinit var sexo: RadioGroup;
    lateinit var calcular: Button;
    var pesoRecuperado: Int = 0;
    var alturaRecuperado: Double = 0.0;
    var sexoRecuperado: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcular.setOnClickListener(){
            calcular = findViewById(R.id.button_calcular)
            peso = findViewById(R.id.edit_peso);
            altura = findViewById(R.id.edit_altura);
        }
    }
}