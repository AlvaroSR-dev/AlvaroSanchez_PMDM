package com.example.hobbies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.core.view.get
import com.example.hobbies.databinding.ActivityPantallaBinding

class PantallaActivity : AppCompatActivity() {
    lateinit var binding: ActivityPantallaBinding
    lateinit var arrayRecyclerView: ArrayList<Elemento>
    lateinit var arraySpinner: ArrayList<String>
    lateinit var adaptadorSpinner: AdaptadorSpinner
    lateinit var adaptadorRecyclerView: AdaptadorRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaBinding.inflate(layoutInflater)
        arrayRecyclerView = ArrayList()
        arraySpinner = ArrayList()
        adaptadorSpinner = AdaptadorSpinner(arraySpinner, this)
        setContentView(binding.root)
        acciones()
        rellenarSpinner()
        asociarDatos()
    }

    private fun asociarDatos() {
        binding.spinnerLista.adapter = adaptadorSpinner
    }

    private fun rellenarSpinner() {
        arraySpinner.add("Fútbol")
        arraySpinner.add("Juegos")
        arraySpinner.add("Series")
    }

    private fun acciones() {
        binding.spinnerLista.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(binding.spinnerLista.selectedItem.equals("Fútbol")){
                    binding.recyclerViewElementos.adapter = AdaptadorRecyclerView(listOf(
                        Elemento("Messi", "FC. Barcelona", R.drawable.messi),
                        Elemento("Ronaldo", "Brasil", R.drawable.ronaldo),
                        Elemento("Maradona", "Argentina", R.drawable.maradona),
                        Elemento("Zidane", "Francia", R.drawable.zidane)
                    )){elemento -> onItemSelected(elemento)}
                }else if(binding.spinnerLista.selectedItem.equals("Juegos")){
                    binding.recyclerViewElementos.adapter = AdaptadorRecyclerView(listOf(
                        Elemento("Metal Gear", "Sigilo", R.drawable.metal),
                        Elemento("Gran Turismo", "Coches", R.drawable.gt),
                        Elemento("God Of War", "Plataformas", R.drawable.god),
                        Elemento("Final Fantasy X", "Rol", R.drawable.ffx)
                    )){elemento -> onItemSelected(elemento)}
                }else if(binding.spinnerLista.selectedItem.equals("Series")){
                    binding.recyclerViewElementos.adapter = AdaptadorRecyclerView(listOf(
                        Elemento("Stranger Things", "Fantastica", R.drawable.stranger),
                        Elemento("Juego de tronos", "Histórica", R.drawable.tronos),
                        Elemento("Lost", "Fantastica", R.drawable.lost),
                        Elemento("La casa de papel", "Accion", R.drawable.papel)
                    )){elemento -> onItemSelected(elemento)}
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    fun onItemSelected(elemento: Elemento){
        binding.recyclerViewPulsado.adapter = AdaptadorRecyclerView(listOf(elemento)){elemento -> onItemSelected(elemento)}
    }
}