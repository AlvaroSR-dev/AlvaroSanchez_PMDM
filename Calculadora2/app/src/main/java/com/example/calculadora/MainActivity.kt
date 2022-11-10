package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var num1 : Double = 0.0
    private var num2 : Double = 0.0
    private lateinit var operacion : String

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
            if (!binding.textViewResultado.text.contains(".")){
                binding.textViewResultado.append(".")
            }
        }

        binding.buttonPositivoNegativo.setOnClickListener(){
            var numNegativo : Double = binding.textViewResultado.text.toString().toDouble() * -1
            binding.textViewResultado.setText(numNegativo.toString())
        }

        binding.buttonSumar.setOnClickListener(){
            num1 = binding.textViewResultado.text.toString().toDouble()
            binding.textViewResultado.setText("")
            binding.textViewResultado.setHint("0")
            operacion = "suma"
        }

        binding.buttonIgual.setOnClickListener(){
            when (operacion) {
                "suma" -> binding.textViewResultado.setText((num1 + num2).toString())
            }
        }
    }
}