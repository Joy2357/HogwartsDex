package com.example.hogwartsdex.view.frames

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hogwartsdex.R
import com.example.hogwartsdex.databinding.StaffElementBinding
import com.example.hogwartsdex.model.Magos

class VistaProfesores(
    private var context: Context,
    private var staff: ArrayList<Magos>,
    private val clickListener: (Magos) -> Unit
) : RecyclerView.Adapter<VistaProfesores.ViewHolder>() {
    class ViewHolder(view: StaffElementBinding) : RecyclerView.ViewHolder(view.root) {
        val ivStaff = view.ivStaff
        val tvName = view.name
        val tvActor = view.actor
        val tvHouse = view.house
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StaffElementBinding.inflate(LayoutInflater.from(context))
        return ViewHolder(binding)
    }
    override fun getItemCount(): Int = staff.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = staff[position].name
        holder.tvActor.text = staff[position].actor
        holder.tvHouse.text = staff[position].house
        if (staff[position].imagen == "") {
            Glide.with(context)
                .load(R.drawable.maguito)
                .into(holder.ivStaff)
        } else {
            Glide.with(context)
                .load(staff[position].imagen)
                .into(holder.ivStaff)
        }
        holder.itemView.setOnClickListener {
            clickListener(staff[position])
        }
    }
}