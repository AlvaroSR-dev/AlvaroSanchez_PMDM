package com.example.cuadrosdialogo

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class DialogoHora: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val hora = Calendar.getInstance().get(Calendar.HOUR)
        val min = Calendar.getInstance().get(Calendar.MINUTE)

        val dialogo = TimePickerDialog(context, activity as TimePickerDialog.OnTimeSetListener, hora, min,false)
        return dialogo
    }
}