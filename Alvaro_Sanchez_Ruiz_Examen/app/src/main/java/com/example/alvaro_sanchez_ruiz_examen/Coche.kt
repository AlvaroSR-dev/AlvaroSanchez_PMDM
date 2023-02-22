package com.example.alvaro_sanchez_ruiz_examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Coche(var nombre : String, var marca : String, var anio : Int, var combustible : String, var imagen : Int){

    var etiqueta : Int = 0

    fun calcularEtiqueta(){
        if (combustible == "Hibrido"){
            etiqueta = R.drawable.etiquetaeco
        }else if (combustible == "Electrico"){
            etiqueta = R.drawable.etiqueta0
        }else if (combustible == "Gasolina"){
            if (anio >= 2006){
                etiqueta = R.drawable.etiquetac
            }else if (anio >= 2000 || anio <= 2005){
                etiqueta = R.drawable.etiquetab
            }else{
                etiqueta = R.drawable.etiquetaa
            }
        }else if (combustible == "Diesel"){
            if (anio >= 2015){
                etiqueta = R.drawable.etiquetac
            }else if (anio >= 2004 || anio <= 2014){
                etiqueta = R.drawable.etiquetab
            }else{
                etiqueta = R.drawable.etiquetaa
            }
        }
    }
}