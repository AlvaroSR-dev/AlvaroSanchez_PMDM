class Administrador : Persona {
    var pass: String? = null

    constructor() {}
    constructor(id: Int, nombre: String?, pass: String?) : super(id, nombre) {
        this.pass = pass
    }

    override fun getPuntuacion(): Byte {
        TODO("Not yet implemented")
    }

    override fun getValor(): Byte {
        TODO("Not yet implemented")
    }
}