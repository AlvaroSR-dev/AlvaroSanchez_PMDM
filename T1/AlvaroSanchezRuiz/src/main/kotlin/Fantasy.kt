class Fantasy {
    var participantes: ArrayList<Participante>? = null
    var jugadores: ArrayList<Jugador>? = null

    constructor() {}
    constructor(participantes: ArrayList<Participante?>?, jugadores: ArrayList<Jugador?>?) {
        this.participantes = ArrayList()
        this.jugadores = ArrayList()
    }

    fun crearJugadores() {
        jugadores!!.add(Jugador(1, "Marc-André ter Stegen", "Portero", 3000000, 10))
        jugadores!!.add(Jugador(2, "Ronald Araújo", "Defensa", 4000000,0))
        jugadores!!.add(Jugador(3, "Eric García", "Defensa", 1000000,3))
        jugadores!!.add(Jugador(4, "Pedri", "Mediocentro", 5000000,23))
        jugadores!!.add(Jugador(5, "Robert Lewandowski", "Delantero", 8000000,15))
        jugadores!!.add(Jugador(6, "Courtois", "Portero", 3000000,1))
        jugadores!!.add(Jugador(7, "David Alaba", "Defensa", 4000000,5))
        jugadores!!.add(Jugador(8, "Jesús Vallejo", "Defensa", 500000,10))
        jugadores!!.add(Jugador(9, "Luka Modric", "Mediocentro", 5000000,5))
        jugadores!!.add(Jugador(10, "Karim Benzema", "Delantero", 8000000,10))
        jugadores!!.add(Jugador(11, "Ledesma", "Portero", 500000,6))
        jugadores!!.add(Jugador(12, "Juan Cala", "Defensa", 300000,3))
        jugadores!!.add(Jugador(13, "Zaldua", "Defensa", 400000,6))
        jugadores!!.add(Jugador(14, "Alez Fernández", "Mediocentro", 700000,9))
        jugadores!!.add(Jugador(15, "Choco Lozano", "Delantero", 800000,4))
        jugadores!!.add(Jugador(16, "Rajković", "Portero", 300000,3))
        jugadores!!.add(Jugador(17, "Raíllo", "Defensa", 200000,6))
        jugadores!!.add(Jugador(18, "Maffeo", "Defensa", 300000,0))
        jugadores!!.add(Jugador(19, "Ruiz de Galarreta", "Mediocentro", 400000,7))
        jugadores!!.add(Jugador(20, "Remiro", "Portero", 1000000,3))
        jugadores!!.add(Jugador(21, "Elustondo", "Defensa", 900000,5))
        jugadores!!.add(Jugador(22, "Zubeldia", "Defensa", 800000,6))
        jugadores!!.add(Jugador(23, "Zubimendi", "Mediocentro", 1000000,7))
        jugadores!!.add(Jugador(24,"Take Kubo", "Delantero", 800000,4))
        jugadores!!.add(Jugador(25, "Ángel", "Delantero", 300000,4))
    }

    fun addParticipante(participante: Participante){
        participantes!!.add(participante)
    }

    fun iniciarLiga(administrador: Administrador, pass: String){
        /*for (participante: Participante in participantes!!){
            var platillaParticipante: ArrayList<Jugador>? = participante.getPlantilla();

            for (jugador: Jugador in platillaParticipante!!){
                jugador.getPosicion();
            }
        }*/

        if (administrador.pass == pass){
            for (participante: Participante in participantes!!){
                println(participante.nombre + participante.puntos)
                if (participante.plantilla?.size!! < 6){
                    println("PARTICIPANTE CON MENOS DE 6 JUGADORES");
                }else{
                    println("CORRECTO");
                }
            }

        }else{
            println("Acceso denegado")
        }
    }

    fun filtrarJugadores(valor: Int){
        for (jugador: Jugador in jugadores!!){
            if (jugador.valor >= valor){
                println(jugador.nombre + jugador.valor);
            }
        }
    }

    fun mostrarGanador(){
        var ganador: Participante? = null
        for (participante: Participante in participantes!!){
            if (participante.puntos > 0) ganador = participante
        }
        println(ganador.toString())
    }
}