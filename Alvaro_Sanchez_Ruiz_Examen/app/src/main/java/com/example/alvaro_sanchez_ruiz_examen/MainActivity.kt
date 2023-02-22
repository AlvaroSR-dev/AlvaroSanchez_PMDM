package com.example.alvaro_sanchez_ruiz_examen

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.alvaro_sanchez_ruiz_examen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var buttonComprobador : Button
    private lateinit var buttonModelos : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.buttonComprobador.setOnClickListener(){
            val intent = Intent(this, Comprobador::class.java)
            startActivity(intent)
        }

        binding.buttonModelos.setOnClickListener(){
            val intent = Intent(this, Modelos::class.java)
            startActivity(intent)
        }
    }

}