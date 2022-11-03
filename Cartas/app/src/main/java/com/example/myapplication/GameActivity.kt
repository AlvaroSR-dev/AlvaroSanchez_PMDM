package com.example.myapplication

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

class GameActivity : AppCompatActivity(){
    private lateinit var buttonUp : ImageButton
    private lateinit var buttonDown : ImageButton
    private lateinit var fondo : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        instancias()
        acciones()
    }

    private fun acciones() {
        var numRandom : Int
        var carta : Drawable
        buttonUp.setOnClickListener(){
            numRandom = ((Math.random() * 13)+1).roundToInt()
            Toast.makeText(applicationContext,"$numRandom",Toast.LENGTH_SHORT).show()
            carta = "c"+numRandom
            fondo.setBackgroundResource(R.drawable.c1)
        }
        buttonDown.setOnClickListener(){
            numRandom = ((Math.random() * 13)+1).roundToInt()
            Toast.makeText(applicationContext,"$numRandom",Toast.LENGTH_SHORT).show()
            carta = R.drawable.$numRandom
            fondo.bac(R.drawable.c1)
        }
    }

    private fun instancias() {
        buttonUp = this.findViewById(R.id.buttonUp)
        buttonDown = this.findViewById(R.id.buttonDown)
        fondo = this.findViewById(R.id.fondo)
    }
}