class LlamadaNacional(nOrigen: Int, nDestino: Int, duracion: Int, private val franja: Int) :
    Llamada(nOrigen, nDestino, duracion) {
    init {
        calcularCoste()
    }

    override fun calcularCoste() {
        when (franja) {
            1 -> coste = duracion * 0.20
            2 -> coste = duracion * 0.25
            3 -> coste = duracion * 0.30
        }
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Franja: $franja")
    }
}