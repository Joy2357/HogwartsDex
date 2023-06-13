package com.example.hogwartsdex.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hogwartsdex.databinding.ActivityListaProfesoresBinding
import com.example.hogwartsdex.model.Magos
import com.example.hogwartsdex.network.HogwartsApi
import com.example.hogwartsdex.network.RetrofitContainer
import com.example.hogwartsdex.view.Listas.VistaProfesores
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaProfesores : AppCompatActivity() {
    private lateinit var binding: ActivityListaProfesoresBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaProfesoresBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.errorMessage.visibility = View.GONE
        binding.buttonError.visibility = View.GONE
        binding.buttonError.performClick()
    }
    private fun staffClick(magos: Magos) {
        val bundle = Bundle()
        bundle.putString("name", magos.name)
        bundle.putString("house", magos.house)
        bundle.putString("image", magos.imagen)
        bundle.putString("species", magos.species)
        bundle.putString("gender", magos.gender)
        bundle.putString("ancestry", magos.ancestry)
        bundle.putString("birth", magos.birth)
        bundle.putString("patronus", magos.patronus)
        val intent = Intent(this, DetallesProfesores::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
    fun reload(view: View){
        binding.errorMessage. visibility = View.GONE
        binding.buttonError.visibility = View.GONE
        binding.nimbusBar.visibility = View.VISIBLE
        val call = RetrofitContainer.getRetrofitContainer().create(HogwartsApi::class.java)
            .getMagosChars("api/characters/staff")
        call.enqueue(object : Callback<ArrayList<Magos>>{
            override fun onResponse(
                call: Call<ArrayList<Magos>>,
                response: Response<ArrayList<Magos>>
            ) {
                binding.nimbusBar.visibility = View.GONE
                binding.rvStaff.layoutManager = LinearLayoutManager(this@ListaProfesores)
                binding.rvStaff.adapter = VistaProfesores(this@ListaProfesores,response.body()!!
                ) { selectedStaff: Magos -> staffClick(selectedStaff)}
            }
            override fun onFailure(call: Call<ArrayList<Magos>>, t: Throwable) {
                binding.nimbusBar.visibility = View.GONE
                binding.errorMessage.visibility = View.VISIBLE
                binding.buttonError.visibility = View.VISIBLE
            }
        })
    }
}