package Centralita

import Llamada
import LlamadaLocal
import LlamadaProvincial

class Centralita {
    private val listaLlamadas: ArrayList<Llamada?>
    var costeTotal = 0.0

    init {
        listaLlamadas = ArrayList<Llamada?>()
    }

    fun registrarLlamada(llamada: Llamada) {
        listaLlamadas.add(llamada)
        llamada.mostrarDatos()
    }

    fun mostrarLlamadas() {
        for (item in listaLlamadas) {
            item?.mostrarDatos()
        }
    }

    fun mostrarCostes() {
        for (item in listaLlamadas) {
            costeTotal += item?.coste!!
        }
        println("Coste total: $costeTotal")
    }
}