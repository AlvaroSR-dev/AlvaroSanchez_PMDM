package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var buttonEmpezar : Button
    private lateinit var inputNombre : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        buttonEmpezar.setOnClickListener(){
            if (inputNombre.text.isEmpty()){
                Toast.makeText(applicationContext,"Introduce un nombre",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Bienvenido " + inputNombre.text,Toast.LENGTH_SHORT).show()
                val intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
            }
        }
        
    }

    private fun instancias() {
        buttonEmpezar = this.findViewById(R.id.buttonEmpezar)
        inputNombre = this.findViewById(R.id.inputNombre)
    }

}
