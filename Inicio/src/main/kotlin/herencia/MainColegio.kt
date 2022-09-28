package herencia

fun main(){
    var alumno1: Alumno = Alumno("Álvaro", "Sánchez", "1234A", 20, "1234A")
    var alumno2: Alumno = Alumno("Javier", "Sánchez", "1234B", 17, "1234B")

    var profesor1: Profesor = Profesor("Borja", "Martín", "2323Q", 28, 3000);
    var profesor2: Profesor = Profesor("Iván", "Perú", "2111J", 21, 1);

    var listado = ArrayList<Persona>()
    listado.add(alumno1)
    listado.add(alumno2)
    listado.add(profesor1)
    listado.add(profesor2)

    listado.forEach({it.mostrarDatos()})
}