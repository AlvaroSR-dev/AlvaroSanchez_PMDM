package TrabajadoresHerencia

class Jefe(nombre: String, apellido: String, dni: String)
    : Persona(nombre, apellido, dni) {

    var beneficio: Int = 0;
    var acciones: Int = 0;

    constructor(nombre: String, apellido: String, dni: String, acciones: Int, beneficio: Int) : this(
        nombre,
        apellido,
        dni,
        ){
        this.acciones = acciones
        this.beneficio = beneficio
    }

    init {
        println("Se ha agregado al jefe $nombre $apellido")
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Acciones: $acciones")
        println("Beneficio: $beneficio€")
    }

}