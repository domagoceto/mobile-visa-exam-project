package com.kadir.vizeuygulamasi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kadir.vizeuygulamasi.R
import com.kadir.vizeuygulamasi.models.Yemek

class FoodAdapter(
    private val yemekListesi: List<Yemek>,
    private val onItemClick: (Yemek) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val yemekAdi: TextView = itemView.findViewById(R.id.foodNameTextView)
        val yemekResmi: ImageView = itemView.findViewById(R.id.foodImageView)

        fun bind(yemek: Yemek) {
            yemekAdi.text = yemek.isim
            yemekResmi.setImageResource(yemek.resim)
            itemView.setOnClickListener { onItemClick(yemek) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(yemekListesi[position])
    }

    override fun getItemCount() = yemekListesi.size
}

