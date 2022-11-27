package com.example.hobbies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.hobbies.databinding.ActivityMainBinding
import com.example.hobbies.databinding.ActivityPantallaBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.buttonIniciar.setOnClickListener(){
            val intent = Intent(applicationContext, PantallaActivity::class.java)
            startActivity(intent)
        }
    }
}