package com.example.cuadrosdialogo

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class DialogoPersoNombre: DialogFragment() {
    lateinit var vista: View;
    lateinit var editTextNombre: EditText
    lateinit var buttonAceptar: Button
    lateinit var listener: OnNombreListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_nombre,null)
        listener = context as OnNombreListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        editTextNombre = vista.findViewById(R.id.editTextNombre)
        buttonAceptar = vista.findViewById(R.id.buttonAceptar)
    }

    override fun onResume() {
        super.onResume()
        buttonAceptar.setOnClickListener {
            run {
                Log.v("Nombre: ", editTextNombre.text.toString())
                listener.onNombreSelected(editTextNombre.text.toString())
                dismiss()
            }
        }
    }

    interface OnNombreListener{
        fun onNombreSelected(dato: String){}
    }
}