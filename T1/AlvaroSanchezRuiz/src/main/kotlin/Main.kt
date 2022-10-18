object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val fantasy = Fantasy()
        fantasy.crearJugadores()
        val participante1 = Participante(1, "Participante 1")
        fantasy.addParticipante(participante1)
        val participante2 = Participante(2, "Participante 2")
        fantasy.addParticipante(participante2)
        val participante3 = Participante(3, "Participante 3")
        fantasy.addParticipante(participante3)
        val participante4 = Participante(4, "Participante 4")
        fantasy.addParticipante(participante4)

        val administrador = Administrador(1, "Admin", "1234")


        participante1.anadirJugador(Jugador(1, "Marc-André ter Stegen", "Portero", 3000000, 10))
        participante2.anadirJugador(Jugador(1, "Marc-André ter Stegen", "Portero", 3000000, 10))
        participante3.anadirJugador(Jugador(1, "Marc-André ter Stegen", "Portero", 3000000, 10))
        participante4.anadirJugador(Jugador(1, "Marc-André ter Stegen", "Portero", 3000000, 10))

        participante1.anadirJugador(Jugador(2,"Ronald Araújo", "Defensa",4000000, 0))
        participante2.anadirJugador(Jugador(2,"Ronald Araújo", "Defensa",4000000, 0))
        participante3.anadirJugador(Jugador(2,"Ronald Araújo", "Defensa",4000000, 0))
        participante4.anadirJugador(Jugador(2,"Ronald Araújo", "Defensa",4000000, 0))

        participante1.anadirJugador(Jugador(3, "Eric García", "Defensa", 1000000,3))
        participante2.anadirJugador(Jugador(3, "Eric García", "Defensa", 1000000,3))
        participante3.anadirJugador(Jugador(3, "Eric García", "Defensa", 1000000,3))
        participante4.anadirJugador(Jugador(3, "Eric García", "Defensa", 1000000,3))

        participante1.anadirJugador(Jugador(4, "Pedri", "Mediocentro", 5000000,23))
        participante2.anadirJugador(Jugador(4, "Pedri", "Mediocentro", 5000000,23))
        participante3.anadirJugador(Jugador(4, "Pedri", "Mediocentro", 5000000,23))
        participante4.anadirJugador(Jugador(4, "Pedri", "Mediocentro", 5000000,23))

        participante1.anadirJugador(Jugador(9, "Luka Modric", "Mediocentro", 5000000,5))
        participante2.anadirJugador(Jugador(9, "Luka Modric", "Mediocentro", 5000000,5))
        participante3.anadirJugador(Jugador(9, "Luka Modric", "Mediocentro", 5000000,5))
        participante4.anadirJugador(Jugador(9, "Luka Modric", "Mediocentro", 5000000,5))

        participante1.anadirJugador(Jugador(16, "Rajković", "Portero", 300000,3))
        participante2.anadirJugador(Jugador(16, "Rajković", "Portero", 300000,3))
        participante4.anadirJugador(Jugador(11, "Ledesma", "Portero", 500000,6))

        fantasy.filtrarJugadores(3000000)

        fantasy.iniciarLiga(administrador, "1234");
        fantasy.mostrarGanador();
    }
}