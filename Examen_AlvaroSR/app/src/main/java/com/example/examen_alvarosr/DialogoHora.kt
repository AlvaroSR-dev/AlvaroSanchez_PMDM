package com.example.examen_alvarosr

import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoHora: DialogFragment() {
    val hora = Calendar.getInstance().get(Calendar.HOUR)
    val min = Calendar.getInstance().get(Calendar.MINUTE)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogo = TimePickerDialog(context, activity as TimePickerDialog.OnTimeSetListener, hora, min,true)
        return dialogo
    }
}