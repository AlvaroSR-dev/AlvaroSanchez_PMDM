package TrabajadoresHerencia

open class Persona (var nombre: String, var apellido: String, val dni: String) {

    constructor(nombre: String, apellido: String, dni: String, edad: Int):
        this(nombre,apellido,dni){
    }

    open fun mostrarDatos(){
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
    }

}