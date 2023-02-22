package com.example.examen_alvarosr

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_alvarosr.adapters.AdaptadorVuelos
import com.example.examen_alvarosr.databinding.ActivityMainBinding
import com.example.examen_alvarosr.model.Vuelo
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, AdaptadorVuelos.OnVueloListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var seleccionado: String
    private lateinit var fecha: String
    private lateinit var hora: String
    private lateinit var arrayVuelos: ArrayList<Vuelo>
    private lateinit var adaptadorVuelos: AdaptadorVuelos
    private lateinit var vueloRecycler: RecyclerView

    // crear menú

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    // opciones del menú

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_informacion->{
                // acción para info
                DialogoInfo().show(supportFragmentManager,"")
            }
            R.id.menu_cerrar->{
                // acción para cerrar
                finish()
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root;
        setContentView(view)
        vueloRecycler = binding.recyclerView
        arrayVuelos = ArrayList()
        val ciudades = arrayOf("Barcelona","Londres","Madrid","Miami","Nueva York","San Francisco")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, ciudades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerIda.setAdapter(adapter)
        binding.spinnerVuelta.setAdapter(adapter)

        acciones()
    }

    private fun acciones() {
        binding.textViewFechaIda.setOnClickListener(){
            seleccionado = "ida"
            DialogoFecha().show(supportFragmentManager,"")
        }

        binding.textViewFechaVuelta.setOnClickListener(){
            seleccionado = "vuelta"
            DialogoFecha().show(supportFragmentManager,"")
        }

        binding.buttonAgregar.setOnClickListener(){
            var vuelo: Vuelo = Vuelo(
                binding.spinnerIda.selectedItem.toString(),
                binding.spinnerVuelta.selectedItem.toString(),
                binding.textViewFechaIda.text.toString(),
                binding.textViewFechaVuelta.text.toString(),
                R.drawable.barcelona,
                R.drawable.madrid)
            arrayVuelos.add(vuelo)
            adaptadorVuelos = AdaptadorVuelos(this, arrayVuelos)
            configurarRecycler()
        }
    }

    private fun devolverImagen(string: String): Int{
        var posicion: Int = 0
            if (string == "Barcelona"){
                posicion = R.drawable.barcelona
            }
        return posicion
    }

    private fun configurarRecycler() {
        vueloRecycler.adapter = adaptadorVuelos
        vueloRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun onVueloClick(vuelo: Vuelo) {
        Log.v("prueba", vuelo.origen)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        fecha = "${p3}/${p2}/${p1}"

        Snackbar.make(binding.root, fecha, Snackbar.LENGTH_SHORT ).show()
        DialogoHora().show(supportFragmentManager,"")
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        hora = "${p1}:${p2}"
        if (seleccionado.equals("ida")){
            binding.textViewFechaIda.text = "${fecha} ${hora}"
        }else{
            binding.textViewFechaVuelta.text = "${fecha} ${hora}"
        }
        Snackbar.make(binding.root, hora, Snackbar.LENGTH_SHORT ).show()
    }
}