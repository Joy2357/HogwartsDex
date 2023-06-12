package com.example.hogwartsdex.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hogwartsdex.databinding.ActivityStudentsViewBinding
import com.example.hogwartsdex.model.Magos
import com.example.hogwartsdex.network.HogwartsApi
import com.example.hogwartsdex.network.RetrofitContainer
import com.example.hogwartsdex.view.frames.VistaEstudiantes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaEstudiantes : AppCompatActivity() {
    private lateinit var binding: ActivityStudentsViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentsViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.errorMessage.visibility = View.GONE
        binding.buttonError.visibility = View.GONE
        binding.buttonError.performClick()
    }
    private fun studentClick(magos: Magos) {
        val bundle = Bundle()
        bundle.putString("name", magos.name)
        bundle.putString("house", magos.house)
        bundle.putString("image", magos.imagen)
        bundle.putString("species", magos.species)
        bundle.putString("gender", magos.gender)
        bundle.putString("ancestry", magos.ancestry)
        bundle.putString("birth", magos.birth)
        bundle.putString("patronus", magos.patronus)
        val intent = Intent(this, DetallesEstudiantes::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
    fun reload(view: View) {
        binding.errorMessage. visibility = View.GONE
        binding.buttonError.visibility = View.GONE
        binding.nimbusBar.visibility = View.VISIBLE
        val call = RetrofitContainer.getRetrofitContainer().create(HogwartsApi::class.java)
            .getMagosChars("api/characters/students")
        call.enqueue(object : Callback<ArrayList<Magos>> {
            override fun onResponse(
                call: Call<ArrayList<Magos>>,
                response: Response<ArrayList<Magos>>
            ) {
                binding.nimbusBar.visibility = View.GONE
                binding.rvStudent.layoutManager = LinearLayoutManager(this@ListaEstudiantes)
                binding.rvStudent.adapter = VistaEstudiantes(this@ListaEstudiantes,response.body()!!
                ) { selectedMagos: Magos -> studentClick(selectedMagos) }
            }
            override fun onFailure(call: Call<ArrayList<Magos>>, t: Throwable) {
                binding.nimbusBar.visibility = View.GONE
                binding.errorMessage.visibility = View.VISIBLE
                binding.buttonError.visibility = View.VISIBLE
            }
        })
    }
}