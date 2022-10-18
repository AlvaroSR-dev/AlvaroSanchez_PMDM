class Jugador : Persona {
    var valor = 0
    var puntuacion = 0
    var posicion: String? = null

    constructor() {}
    constructor(id: Int, nombre: String?, posicion: String?, valor: Int, puntuacion: Int) : super(id, nombre) {
        this.posicion = posicion
        this.valor = valor
        this.puntuacion = puntuacion
    }

    override fun mostrarDatos() {
        println("ID: $id")
        println("Nombre: $nombre")
        println("Valor: " + valor + "€")
        println("Puntuación: $puntuacion")
        println("Posición: $posicion")
    }
}