abstract class Persona {
    var id = 0
    var nombre: String? = null

    constructor() {}
    constructor(id: Int, nombre: String?) {
        this.id = id
        this.nombre = nombre
    }

    open fun mostrarDatos() {
        println("ID: $id")
        println("Nombre: $nombre")
    }

    abstract fun getPuntuacion(): Byte
    abstract fun getValor(): Byte
}