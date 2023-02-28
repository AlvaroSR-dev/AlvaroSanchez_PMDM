package com.example.cuadrosdialogo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class DialogoMedia: DialogFragment()  {
    lateinit var vista: View;
    lateinit var editTextMedia: EditText
    lateinit var buttonAceptar: Button
    lateinit var listener: DialogoPersoNombre.OnNombreListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_nombre,null)
        listener = context as DialogoPersoNombre.OnNombreListener
    }

    interface OnNombreListener{
        fun onNombreSelected(dato: String)
    }
}