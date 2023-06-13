package com.example.hogwartsdex.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.hogwartsdex.R
import com.example.hogwartsdex.databinding.ActivityDetallesProfesoresBinding

class DetallesProfesores : AppCompatActivity() {
    private lateinit var binding: ActivityDetallesProfesoresBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesProfesoresBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        if (bundle != null) {
            binding.name.text = bundle.getString("name", "")
            binding.birth.text = bundle.getString("birth", "")
            binding.species.text = bundle.getString("species", "")
            binding.ancestry.text = bundle.getString("ancestry", "")
            binding.patronus.text = bundle.getString("patronus", "")
            binding.gender.text = bundle.getString("gender", "")
            if(binding.name.text == "")
                binding.name.text = getString(R.string.unknown)
            if(binding.species.text == "")
                binding.species.text = getString(R.string.unknown)
            if(binding.gender.text == "")
                binding.gender.text = getString(R.string.unknown)
            if(binding.ancestry.text == "")
                binding.ancestry.text = getString(R.string.unknown)
            if(binding.birth.text == "")
                binding.birth.text = getString(R.string.unknown)
            if(binding.patronus.text == "")
                binding.patronus.text = getString(R.string.unknown)
            if(bundle.getString("image", "") == ""){
                Glide.with(this)
                    .load(R.drawable.maguito)
                    .into(binding.roundedImageView)
            }else {
                Glide.with(this)
                    .load(bundle.getString("image", ""))
                    .into(binding.roundedImageView)
            }
            val house = when(bundle.getString("house", "")){
                "Gryffindor" -> R.drawable.gryffindor
                "Slytherin" -> R.drawable.slytherin
                "Hufflepuff" -> R.drawable.hufflepuff
                "Ravenclaw" -> R.drawable.ravenclaw
                else -> R.drawable.nimbus
            }
            binding.houseLogo.setImageResource(house)
        }
    }
}