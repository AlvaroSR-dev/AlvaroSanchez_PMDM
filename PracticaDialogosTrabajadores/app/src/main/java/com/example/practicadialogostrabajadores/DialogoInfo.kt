package com.example.practicadialogostrabajadores

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoInfo: DialogFragment() {


    companion object{
        fun newInstance(trabajador: Trabajador): DialogoInfo {
            val args = Bundle()
            args.putString("Nombre completo", "${trabajador.nombre} ${trabajador.apellidos}")
            args.putString("Email", "Email: ${trabajador.correo}")
            args.putString("Puesto", "Puesto: ${trabajador.trabajo}")
            args.putString("Edad", "Edad: ${trabajador.edad}")
            args.putString("Trabajo", trabajador.trabajo)
            val fragment = DialogoInfo()
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireActivity())

        var nombreCompleto = this.arguments?.get("Nombre completo")
        var email = this.arguments?.get("Email")
        var puesto = this.arguments?.get("Puesto")
        var edad = this.arguments?.get("Edad")
        var trabajo = this.arguments?.get("Trabajo")

        when (trabajo) {
            "Administrativo" -> builder.setIcon(R.drawable.administrativo)
            "Comercial" -> builder.setIcon(R.drawable.comercial)
            "Soporte" -> builder.setIcon(R.drawable.soporte)
            "Informática" -> builder.setIcon(R.drawable.informatica)
        }
        builder.setTitle(nombreCompleto.toString())
        builder.setMessage("${email}\n${puesto}\n${edad}\nPuesto: ${trabajo}")

        return builder.create()
    }

}