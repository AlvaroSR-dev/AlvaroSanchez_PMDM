package com.example.examen_alvarosr

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoInfo: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var  builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Información del examen:")
            .setMessage("Nombre: Álvaro Sánchez Ruiz \n Email: alvaro.sanchez@cesjuanpablosegundo.es")
            .setIcon(android.R.drawable.ic_dialog_info)
        return builder.create()
    }
}