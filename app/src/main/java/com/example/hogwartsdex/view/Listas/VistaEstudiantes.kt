package com.example.hogwartsdex.view.Listas

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hogwartsdex.R
import com.example.hogwartsdex.databinding.VistaEstudiantesBinding

import com.example.hogwartsdex.model.Magos

class VistaEstudiantes(
    private var context: Context,
    private var magos: ArrayList<Magos>,
    private val clickListener: (Magos) -> Unit
) : RecyclerView.Adapter<VistaEstudiantes.ViewHolder>() {
    class ViewHolder(view: VistaEstudiantesBinding) : RecyclerView.ViewHolder(view.root) {
        val ivStudent = view.ivStudent
        val tvName = view.name
        val tvActor = view.actor
        val tvHouse = view.house
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = VistaEstudiantesBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }
    override fun getItemCount(): Int = magos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = magos[position].name
        holder.tvActor.text = magos[position].actor
        holder.tvHouse.text = magos[position].house
        if (magos[position].imagen == "") {
            Glide.with(context)
                .load(R.drawable.maguito)
                .into(holder.ivStudent)
        } else {
            Glide.with(context)
                .load(magos[position].imagen)
                .into(holder.ivStudent)
        }
        holder.itemView.setOnClickListener {
            clickListener(magos[position])
        }
    }
}