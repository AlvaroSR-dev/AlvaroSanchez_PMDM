import Centralita.Centralita

object Entrada {
    @JvmStatic
    fun main(args: Array<String>) {
        val centralita: Centralita = Centralita()
        val llamadaNacional: Llamada = LlamadaNacional(667758, 494978, 21, 2)
        val llamadaLocal: Llamada = LlamadaLocal(797944, 111111, 10)
        val llamadaProvincial: Llamada = LlamadaProvincial(505097, 326598, 5)

        centralita.registrarLlamada(llamadaNacional)
        centralita.registrarLlamada(llamadaLocal)
        centralita.registrarLlamada(llamadaProvincial)

        centralita.mostrarLlamadas()
        centralita.mostrarCostes()
    }
}