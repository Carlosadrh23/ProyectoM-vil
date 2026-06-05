package com.example.proyectoairbnbmovil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Property(
    val name: String,
    val dates: String,
    val price: String,
    val rating: String,
    val imageRes: Int
)

class PropertyAdapter(private val properties: List<Property>) :
    RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {

    inner class PropertyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProperty: ImageView = itemView.findViewById(R.id.ivProperty)
        val tvPropertyName: TextView = itemView.findViewById(R.id.tvPropertyName)
        val tvDates: TextView = itemView.findViewById(R.id.tvDates)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_property, parent, false)
        return PropertyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        val property = properties[position]
        holder.ivProperty.setImageResource(property.imageRes)
        holder.tvPropertyName.text = property.name
        holder.tvDates.text = property.dates
        holder.tvPrice.text = property.price
        holder.tvRating.text = property.rating
    }

    override fun getItemCount() = properties.size
}