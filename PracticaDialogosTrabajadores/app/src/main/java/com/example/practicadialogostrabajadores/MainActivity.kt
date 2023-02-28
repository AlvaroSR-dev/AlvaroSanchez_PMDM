package com.example.practicadialogostrabajadores

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicadialogostrabajadores.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

/*

Crear una aplicación para gestionar los trabajadores de una empresa. Para ello la aplicación contaría con una pantalla donde:

En el 40% superior aparezca un formulario de introducir los datos del trabajador:
    Nombre, Apellidos, Correo, Edad, Puesto de trabajo (un spinner con las opciones administrativo, comercial, soporte, informática) y un botón de guardar.
    Al pulsar el botón se agregará un objeto de tipo usuario al RecyclerView de la parte inferior

En el 60% restante mostrar un RecyclerView lineal donde irán apareciendo los usuarios que se introducen con el formulario de la parte superior.
En dicho RecyclerView tan solo se mostrará el nombre y el apellido. Al pulsar en cualquier parte de la fila aparecerá un cuadro de diálogo con todos los detalles del usuario.

 */

class MainActivity : AppCompatActivity(), AdaptadorTrabajador.OnTrabajadorListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var arrayTrabajadores: ArrayList<Trabajador>
    private lateinit var adaptadorTrabajador: AdaptadorTrabajador
    private lateinit var trabajadorRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trabajadorRecycler = binding.recyclerView
        arrayTrabajadores = ArrayList()

        rellenarSpinner()
        acciones()
    }

    private fun rellenarSpinner() {
        val trabajos = arrayOf("Administrativo","Comercial","Soporte","Informática")
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, trabajos)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerTrabajo.adapter = adapter
    }

    private fun acciones() {
        binding.buttonGuardar.setOnClickListener(){
            if (!esVacio()){
                var trabajador = Trabajador(
                    binding.editTextNombre.text.toString(),
                    binding.editTextApellidos.text.toString(),
                    binding.editTextEmail.text.toString(),
                    binding.editTextEdad.text.toString().toInt(),
                    binding.spinnerTrabajo.selectedItem.toString()
                )

                arrayTrabajadores.add(trabajador)
                configurarRecycler()
                limpiarCampos()
            }else{
                Snackbar.make(binding.root, "Falta un dato", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun esVacio(): Boolean{
        return (binding.editTextNombre.text.isEmpty() || binding.editTextApellidos.text.isEmpty() || binding.editTextEdad.text.isEmpty() || binding.editTextEmail.text.isEmpty())
    }

    private fun limpiarCampos(){
        binding.editTextNombre.text.clear()
        binding.editTextApellidos.text.clear()
        binding.editTextEmail.text.clear()
        binding.editTextEdad.text.clear()
    }

    private fun configurarRecycler() {
        adaptadorTrabajador = AdaptadorTrabajador(this, arrayTrabajadores)
        trabajadorRecycler.adapter = adaptadorTrabajador
        trabajadorRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }

    override fun onTrabajadorClick(trabajador: Trabajador) {
        Snackbar.make(binding.root, trabajador.nombre, Snackbar.LENGTH_SHORT ).show()
        DialogoInfo.newInstance(trabajador).show(supportFragmentManager, "")
    }
}