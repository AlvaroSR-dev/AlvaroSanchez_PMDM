package com.example.myapplication

import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
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
        buttonUp.setOnClickListener(){
            numRandom = ((Math.random() * 12)+1).roundToInt()
            Toast.makeText(applicationContext,"$numRandom",Toast.LENGTH_SHORT).show()

            when(numRandom){
                1 -> fondo.setBackgroundResource(R.drawable.c1)
                2 -> fondo.setBackgroundResource(R.drawable.c2)
                3 -> fondo.setBackgroundResource(R.drawable.c3)
                4 -> fondo.setBackgroundResource(R.drawable.c4)
                5 -> fondo.setBackgroundResource(R.drawable.c5)
                6 -> fondo.setBackgroundResource(R.drawable.c6)
                7 -> fondo.setBackgroundResource(R.drawable.c7)
                8 -> fondo.setBackgroundResource(R.drawable.c8)
                9 -> fondo.setBackgroundResource(R.drawable.c9)
                10 -> fondo.setBackgroundResource(R.drawable.c10)
                11 -> fondo.setBackgroundResource(R.drawable.c11)
                12 -> fondo.setBackgroundResource(R.drawable.c12)
                13 -> fondo.setBackgroundResource(R.drawable.c13)
            }
        }
        buttonDown.setOnClickListener(){
            numRandom = ((Math.random() * 12)+1).roundToInt()
            Toast.makeText(applicationContext,"$numRandom",Toast.LENGTH_SHORT).show()

            when(numRandom){
                1 -> fondo.setBackgroundResource(R.drawable.c1)
                2 -> fondo.setBackgroundResource(R.drawable.c2)
                3 -> fondo.setBackgroundResource(R.drawable.c3)
                4 -> fondo.setBackgroundResource(R.drawable.c4)
                5 -> fondo.setBackgroundResource(R.drawable.c5)
                6 -> fondo.setBackgroundResource(R.drawable.c6)
                7 -> fondo.setBackgroundResource(R.drawable.c7)
                8 -> fondo.setBackgroundResource(R.drawable.c8)
                9 -> fondo.setBackgroundResource(R.drawable.c9)
                10 -> fondo.setBackgroundResource(R.drawable.c10)
                11 -> fondo.setBackgroundResource(R.drawable.c11)
                12 -> fondo.setBackgroundResource(R.drawable.c12)
                13 -> fondo.setBackgroundResource(R.drawable.c13)
            }
        }
    }

    private fun instancias() {
        buttonUp = this.findViewById(R.id.buttonUp)
        buttonDown = this.findViewById(R.id.buttonDown)
        fondo = this.findViewById(R.id.fondo)
    }
}