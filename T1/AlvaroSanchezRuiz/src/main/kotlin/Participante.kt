class Participante : Persona {
    var plantilla: ArrayList<Jugador>? = null
    var puntos = 0
    var presupuesto = 0

    constructor() {}
    constructor(id: Int, nombre: String?) : super(id, nombre) {}
    constructor(id: Int, nombre: String?, plantilla: ArrayList<Jugador?>?, puntos: Int, presupuesto: Int) : super(
        id,
        nombre
    ) {
        this.plantilla = ArrayList()
        this.puntos = puntos
        this.presupuesto = 10000000
    }

    fun tieneJugador(jugador: Jugador): Boolean {
        for (item in plantilla!!) {
            if (jugador === item) {
                return true
            }
        }
        return false
    }

    fun anadirJugador(jugador: Jugador) {
        if (tieneJugador(jugador) == true) {
            println("Ya tienes a este jugador")
        } else {
            if (jugador.getValor() <= presupuesto){
                plantilla!!.add(jugador)
                presupuesto -= jugador.getValor()
                puntos += jugador.getPuntuacion()
                println("Se ha añadido al jugador " + jugador.nombre)
                println("Tienes " + presupuesto + "€ disponible")
                println("Tienes " + puntos + "puntos")
            }else{
                println("No tienes suficiente presupuesto")
            }
        }
    }

    override fun mostrarDatos() {
        println("ID: $id")
        println("Nombre: $nombre")
        println("Puntos: $puntos")
        println("Presupuesto: $presupuesto")
        println("Plantilla:")
        for (item in plantilla!!) {
            item.mostrarDatos()
        }
    }

    override fun getPuntuacion(): Byte {
        TODO("Not yet implemented")
    }

    override fun getValor(): Byte {
        TODO("Not yet implemented")
    }
}