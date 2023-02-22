import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.example.cuadrosdialogo.DialogoMultiple
import com.example.cuadrosdialogo.MainActivity

class DialogoConfirmacion : DialogFragment() {

    companion object{
        fun newInstance(nombre: String, fecha: String, hora: String): DialogoConfirmacion {
            val args = Bundle()
            args.putString("nombre", nombre)
            args.putString("fecha", fecha)
            args.putString("hora", hora)
            val fragment = DialogoConfirmacion()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Confirmación")
            .setMessage("Buenos días ${this.arguments?.get("nombre")} vas a registrar una respuesta el ${this.arguments?.get("fecha")} a las ${this.arguments?.get("hora")}. ¿Estás seguro que quieres continuar?")
            .setPositiveButton("Aceptar") { dialogInterface, posicion ->
                Log.v(
                    "dialogos",
                    "Pulsado aceptar "+posicion.toString()
                )
                DialogoMultiple().show(parentFragmentManager, "")
            }.setNegativeButton("Cancelar"){ dialogInterface, posicion ->
                Log.v(
                    "dialogos",
                    "Pulsado cancelar "+posicion.toString()
                )
            }

        return builder.create()
    }

    interface OnConfirmacionListener{
        fun onConfirmacionSelected(seleccionado: Boolean)
    }
}