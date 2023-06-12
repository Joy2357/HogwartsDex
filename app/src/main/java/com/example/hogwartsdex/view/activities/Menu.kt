package com.example.hogwartsdex.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hogwartsdex.databinding.ActivityCharacterMenuBinding

class Menu : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun studentsViewClick(view: View) {
        var intent = Intent(this, ListaEstudiantes::class.java)
        startActivity(intent)
    }
    fun staffViewClick(view: View) {
        var intent = Intent(this, ListaProfesores::class.java)
        startActivity(intent)
    }
}