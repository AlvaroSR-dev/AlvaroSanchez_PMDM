package com.example.myapplication

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text
import java.io.File
import kotlin.math.roundToInt

class GameActivity : AppCompatActivity(){
    private lateinit var buttonUp : ImageButton
    private lateinit var buttonDown : ImageButton
    private lateinit var fondo : FrameLayout
    private lateinit var textPuntos : TextView
    private var cartas : Array<Int> = arrayOf(R.drawable.cf, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10, R.drawable.c11, R.drawable.c12, R.drawable.c13)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        instancias()
        acciones()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun acciones() {
        var numRandom : Int
        var numRandom2 : Int
        var puntos : Int = 0
        numRandom = ((Math.random() * 12).toInt())+1
        fondo.setBackgroundResource(cartas[numRandom])

        if (buttonDown.isPressed){
            buttonDown.setImageResource(R.drawable.down_press)
        }

        if (buttonUp.isHovered){
            buttonUp.setImageResource(R.drawable.up_press)
        }

        buttonUp.setOnClickListener(){
            numRandom2 = ((Math.random() * 12).toInt())+1
            fondo.setBackgroundResource(cartas[numRandom2])
            if (numRandom2 > numRandom){
                println("MAYOR")
                puntos++
                textPuntos.setText("Puntos: $puntos")

            }else if (numRandom2 < numRandom){
                println("MENOR")
                buttonUp.isEnabled = false
                buttonDown.isEnabled = false
                var notificacion =
                    Snackbar.make(buttonUp, "Juego terminado", Snackbar.LENGTH_INDEFINITE)
                    notificacion.setAction("¿Volver al inicio?") {
                        var intent: Intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(intent)
                }
                notificacion.show()
            }

            numRandom = numRandom2
        }

        buttonDown.setOnClickListener(){
            numRandom2 = ((Math.random() * 12).toInt())+1
            fondo.setBackgroundResource(cartas[numRandom2])
            if (numRandom2 < numRandom){
                println("MENOR")
                puntos++
                textPuntos.setText("Puntos: $puntos")
            }else if (numRandom2 > numRandom){
                println("MAYOR")
                buttonUp.isEnabled = false
                buttonDown.isEnabled = false
                var notificacion =
                    Snackbar.make(buttonUp, "Juego terminado", Snackbar.LENGTH_INDEFINITE)
                notificacion.setAction("¿Volver al inicio?") {
                    var intent: Intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                }
                notificacion.show()
            }

            numRandom = numRandom2
        }
    }

    private fun instancias() {
        buttonUp = this.findViewById(R.id.buttonUp)
        buttonDown = this.findViewById(R.id.buttonDown)
        fondo = this.findViewById(R.id.fondo)
        textPuntos = this.findViewById(R.id.textPuntos)
    }
}