package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var editTextResultado : EditText
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.buttonAc.setOnClickListener(){
            binding.textViewResultado.setText("")
        }

        binding.buttonCero.setOnClickListener(){
            binding.textViewResultado.append("0")
        }

        binding.buttonUno.setOnClickListener(){
            binding.textViewResultado.append("1")
        }

        binding.buttonDos.setOnClickListener(){
            binding.textViewResultado.append("2")
        }

        binding.buttonTres.setOnClickListener(){
            binding.textViewResultado.append("3")
        }

        binding.buttonCuatro.setOnClickListener(){
            binding.textViewResultado.append("4")
        }

        binding.buttonCinco.setOnClickListener(){
            binding.textViewResultado.append("5")
        }

        binding.buttonSeis.setOnClickListener(){
            binding.textViewResultado.append("6")
        }

        binding.buttonSiete.setOnClickListener(){
            binding.textViewResultado.append("7")
        }

        binding.buttonOcho.setOnClickListener(){
            binding.textViewResultado.append("8")
        }

        binding.buttonNueve.setOnClickListener(){
            binding.textViewResultado.append("9")
        }

        binding.buttonDecimal.setOnClickListener(){
            //if (editTextResultado.text.contains(".") == false){
                editTextResultado.append(".")
            //}
        }
    }
}