package com.example.cuadrosdialogo

import DialogoConfirmacion
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.cuadrosdialogo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener, DialogoPersoNombre.OnNombreListener, DialogoMultiple.OnListaListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var hora: String
    private lateinit var fecha: String
    private lateinit var nombre: String
    private lateinit var min: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones(){
        binding.buttonArrancar.setOnClickListener(){
            DialogoHora().show(supportFragmentManager, "")
        }
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        min = p2.toString()
        hora = "${p1}:${min}"
        Snackbar.make(binding.root, hora,Snackbar.LENGTH_SHORT ).show()
        DialogoFecha().show(supportFragmentManager, "")
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        fecha = "${p3}/${p2}/${p1}"
        Snackbar.make(binding.root, fecha,Snackbar.LENGTH_SHORT ).show()
        DialogoPersoNombre().show(supportFragmentManager, "")
    }

    override fun onNombreSelected(dato: String) {
        nombre = dato
        Snackbar.make(binding.root, "Nombre: ${nombre}",Snackbar.LENGTH_SHORT ).show()
        val dialogoConfirmacion = DialogoConfirmacion.newInstance(nombre, fecha, hora)
        dialogoConfirmacion.show(supportFragmentManager, "" )
    }

    override fun onElementoListaSelected(elementos: Int) {
        Snackbar.make(binding.root, elementos.toString(),Snackbar.LENGTH_SHORT ).show()
    }
}