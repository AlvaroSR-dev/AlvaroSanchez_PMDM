package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadora.databinding.ActivityMainBinding
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var num1 : Double = 0.0
    private var num2 : Double = 0.0
    private lateinit var operacion : String
    var guardarNum1 : Double = 0.0
    var guardarNum2 : Double = 0.0
    var guardarPantalla : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.buttonAc.setOnClickListener(){
            binding.textViewResultado.text = ""
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

        binding.buttonPi?.setOnClickListener(){
            binding.textViewResultado.text = "3.14159"
        }

        binding.buttonE?.setOnClickListener(){
            binding.textViewResultado.text = "2.71828"
        }

        binding.buttonSin?.setOnClickListener(){
            var opTemporal : Double = (binding.textViewResultado.text.toString().toDouble())
            binding.textViewResultado.text = (sin(opTemporal)).toString()
        }

        binding.buttonCos?.setOnClickListener(){
            var opTemporal : Double = (binding.textViewResultado.text.toString().toDouble())
            binding.textViewResultado.text = (cos(opTemporal)).toString()
        }

        binding.buttonRaiz?.setOnClickListener(){
            var opTemporal : Double = (binding.textViewResultado.text.toString().toDouble())
            binding.textViewResultado.text = (sqrt(opTemporal)).toString()
        }

        binding.buttonLog?.setOnClickListener(){
            var opTemporal : Double = (binding.textViewResultado.text.toString().toDouble())
            binding.textViewResultado.text = (ln(opTemporal)).toString()
        }

        binding.buttonFacorial?.setOnClickListener(){
            var opTemporal : Double = (binding.textViewResultado.text.toString().toDouble())
            for (i in 1..opTemporal.toInt()) {
                // factorial = factorial * i;
                opTemporal *= i.toLong()
            }
            binding.textViewResultado.text = (opTemporal.toString())
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
            println(num1)
            binding.textViewResultado.setText("")
            binding.textViewResultado.setHint("0")
            operacion = "suma"
        }

        binding.buttonRestar.setOnClickListener(){
            num1 = binding.textViewResultado.text.toString().toDouble()
            binding.textViewResultado.setText("")
            binding.textViewResultado.setHint("0")
            operacion = "resta"
        }

        binding.buttonMultiplicar.setOnClickListener(){
            num1 = binding.textViewResultado.text.toString().toDouble()
            binding.textViewResultado.setText("")
            binding.textViewResultado.setHint("0")
            operacion = "multiplicacion"
        }

        binding.buttonDividir.setOnClickListener(){
            num1 = binding.textViewResultado.text.toString().toDouble()
            binding.textViewResultado.setText("")
            binding.textViewResultado.setHint("0")
            operacion = "division"
        }

        binding.buttonModulo.setOnClickListener(){
            num1 = binding.textViewResultado.text.toString().toDouble()
            binding.textViewResultado.setText("")
            binding.textViewResultado.setHint("0")
            operacion = "modulo"
        }

        binding.buttonElevado?.setOnClickListener(){
            num1 = binding.textViewResultado.text.toString().toDouble()
            binding.textViewResultado.setText("")
            binding.textViewResultado.setHint("0")
            operacion = "elevado"
        }

        binding.buttonElevadoDiez?.setOnClickListener(){
            var opTemporal : Double = (binding.textViewResultado.text.toString().toDouble())
            binding.textViewResultado.text = (opTemporal.pow(10)).toString()
        }

        binding.buttonIgual.setOnClickListener(){
            num2 = binding.textViewResultado.text.toString().toDouble()
            var numResultado : Double = 0.0
            when (operacion) {
                "suma" -> numResultado = num1 + num2
                "resta" -> numResultado = num1 - num2
                "multiplicacion" -> numResultado = num1 * num2
                "division" -> numResultado = num1 / num2
                "modulo" -> numResultado = num1 % num2
                "elevado" -> numResultado = num1.pow(num2)
            }
            println(numResultado)
            binding.textViewResultado.text = numResultado.toString()
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("guardarNum1", num1)
        outState.putDouble("guardarNum2", num2)
        outState.putString("guardarPantalla", binding.textViewResultado.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        guardarNum1 = savedInstanceState.getDouble("guardarNum1", 0.0)
        guardarNum2 = savedInstanceState.getDouble("guardarNum2", 0.0)
        guardarPantalla = savedInstanceState.getString("guardarPantalla", "")!!

        binding.textViewResultado.text = guardarPantalla.toString()
        num1 = guardarNum1
        num2 = guardarNum2
    }
}