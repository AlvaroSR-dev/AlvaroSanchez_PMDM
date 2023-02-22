package com.example.cuadrosdialogo

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DialogoMultiple: DialogFragment() {
    lateinit var asignaturasSeleccionadas: ArrayList<String>
    lateinit var asignaturas: Array<String>

    private lateinit var listener: OnListaListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnListaListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        asignaturasSeleccionadas = ArrayList();
        asignaturas = arrayOf("PMDM", "DI", "AD", "SGE", "EIE", "ING")

        var builder = AlertDialog.Builder(requireContext());
        builder.setTitle("¿De cuántas asignaturas te has evaluado?")
            //.setMessage("Que opción quieres hacer")
            .setMultiChoiceItems(asignaturas, null) { dialogo, posicion, boolean ->
                run {
                    Log.v("multiple","Posición seleccionada: ${posicion}")
                    Log.v("multiple","Valor del seleccionado: ${boolean}")
                    if (boolean) {
                        asignaturasSeleccionadas.add(asignaturas[posicion])
                    } else {
                        asignaturasSeleccionadas.remove(asignaturas[posicion])
                    }
                }
            }
            .setPositiveButton("Aceptar") { dialogo, posicion ->
                run {
                    Log.v(
                        "multiple",
                        "Selección finalizada ${asignaturasSeleccionadas.size}"
                    )
                    asignaturasSeleccionadas.forEach {Log.v("multiple","$it") }
                }
            }
            .setNegativeButton("Cancelar") { dialogInterface, posicion ->
                Log.v(
                    "dialogos",
                    "Pulsado cancelar "+posicion.toString()
                )
            }

        return builder.create()
    }


    interface OnListaListener{
        fun onElementoListaSelected(elemento: String)
    }


}