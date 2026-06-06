package com.example.proyectoairbnbmovil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SavedAdapter(private val properties: List<Property>) :
    RecyclerView.Adapter<SavedAdapter.SavedViewHolder>() {

    inner class SavedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivSavedProperty: ImageView = itemView.findViewById(R.id.ivSavedProperty)
        val tvSavedName: TextView = itemView.findViewById(R.id.tvSavedName)
        val tvSavedDates: TextView = itemView.findViewById(R.id.tvSavedDates)
        val tvSavedPrice: TextView = itemView.findViewById(R.id.tvSavedPrice)
        val tvSavedRating: TextView = itemView.findViewById(R.id.tvSavedRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_saved, parent, false)
        return SavedViewHolder(view)
    }

    override fun onBindViewHolder(holder: SavedViewHolder, position: Int) {
        val property = properties[position]
        holder.ivSavedProperty.setImageResource(property.imageRes)
        holder.tvSavedName.text = property.name
        holder.tvSavedDates.text = property.dates
        holder.tvSavedPrice.text = property.price
        holder.tvSavedRating.text = property.rating
    }

    override fun getItemCount() = properties.size
}