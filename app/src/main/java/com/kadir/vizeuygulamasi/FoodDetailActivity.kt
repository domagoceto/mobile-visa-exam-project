package com.kadir.vizeuygulamasi

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FoodDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        // Navbar başlığını ve geri tuşunu etkinleştir
        supportActionBar?.apply {
            title = intent.getStringExtra("yemekAdi")
            setDisplayHomeAsUpEnabled(true)
        }

        // XML bileşenlerini bağlama
        val foodImageView: ImageView = findViewById(R.id.foodImageView)
        val foodNameTextView: TextView = findViewById(R.id.foodNameTextView)
        val foodIngredientsTextView: TextView = findViewById(R.id.foodIngredientsTextView)
        val foodRecipeTextView: TextView = findViewById(R.id.foodRecipeTextView)

        // Intent verilerini al ve göster
        val foodName = intent.getStringExtra("yemekAdi")
        val foodIngredients = intent.getStringExtra("malzemeler")
        val foodRecipe = intent.getStringExtra("tarif")
        val foodImageRes = intent.getIntExtra("resim", 0)

        foodNameTextView.text = foodName
        foodIngredientsTextView.text = "Malzemeler: $foodIngredients"
        foodRecipeTextView.text = "Tarif: $foodRecipe"
        foodImageView.setImageResource(foodImageRes)
    }

    override fun onSupportNavigateUp(): Boolean {

        return true
    }
}
