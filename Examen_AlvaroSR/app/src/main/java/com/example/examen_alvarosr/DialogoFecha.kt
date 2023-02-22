package com.example.examen_alvarosr

import android.app.DatePickerDialog
import android.app.Dialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoFecha: DialogFragment() {
    val anio = Calendar.getInstance().get(Calendar.YEAR)
    val mes = Calendar.getInstance().get(Calendar.MONTH)
    val dia = Calendar.getInstance().get(Calendar.DATE)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogoFecha = DatePickerDialog(requireContext(),activity as DatePickerDialog.OnDateSetListener, anio, mes, dia)
        return dialogoFecha
    }
}