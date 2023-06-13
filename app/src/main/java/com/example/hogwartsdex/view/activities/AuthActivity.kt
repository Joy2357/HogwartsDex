package com.example.hogwartsdex.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hogwartsdex.databinding.ActivityAuthBinding
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityAuthBinding

    private var email =  ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        //Thread.sleep(2000) // HACK:
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.accbutton.setOnClickListener {
            if(!valida()) return@setOnClickListener
            auntenticaUser(email, password)
        }

        binding.regbutton.setOnClickListener {
            if(!valida()) return@setOnClickListener
            registraUser(email, password)
        }
    }

    private fun registraUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
            autnResult ->
            if(autnResult.isSuccessful)
                binding.regbutton.text = "Correcto"
        }
    }

    private fun valida(): Boolean{
        email = binding.emailEditText.text.toString().trim()
        password = binding.passwordEditText.text.toString().trim()

        if(email.isEmpty()){
            binding.emailEditText.error="No ingreso correo"
            binding.emailEditText.requestFocus()
            return false
        }
        if(password.isEmpty()|| password.length <6){
            binding.passwordEditText.error="No ingreso contraseña"
            binding.emailEditText.requestFocus()
            return false
        }
        return true
    }
    private fun auntenticaUser(usr: String, psw: String){
        firebaseAuth.signInWithEmailAndPassword(usr, psw).addOnCompleteListener {
            authResult ->
            if(authResult.isSuccessful){
                var intent = Intent(this, Menu::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}