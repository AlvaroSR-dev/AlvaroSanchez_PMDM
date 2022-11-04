abstract class Llamada {
    protected var nOrigen = 0
    protected var nDestino = 0
    var duracion = 0
    var coste = 0.0

    constructor() {}
    constructor(nOrigen: Int, nDestino: Int, duracion: Int) {
        this.nOrigen = nOrigen
        this.nDestino = nDestino
        this.duracion = duracion
        calcularCoste()
    }

    protected abstract fun calcularCoste()
    open fun mostrarDatos() {
        print("Origen: $nOrigen\n Destino: $nDestino\n Duracion: $duracion\n Coste: $coste\n")
    }

    fun getnOrigen(): Int {
        return nOrigen
    }

    fun setnOrigen(nOrigen: Int) {
        this.nOrigen = nOrigen
    }

    fun getnDestino(): Int {
        return nDestino
    }

    fun setnDestino(nDestino: Int) {
        this.nDestino = nDestino
    }
}