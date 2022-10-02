class LlamadaProvincial(nOrigen: Int, nDestino: Int, duracion: Int) : Llamada(nOrigen, nDestino, duracion) {

    override fun calcularCoste() {
        coste = duracion * 0.15
    }
}