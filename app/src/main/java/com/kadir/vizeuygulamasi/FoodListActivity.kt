package com.kadir.vizeuygulamasi

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kadir.vizeuygulamasi.adapters.FoodAdapter
import com.kadir.vizeuygulamasi.dialogs.AddFoodDialog
import com.kadir.vizeuygulamasi.models.Yemek

class FoodListActivity : AppCompatActivity() {

    private val yemekListesi = mutableListOf(*Yemek.ornekYemekler.toTypedArray())
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_list)

        val recyclerView = findViewById<RecyclerView>(R.id.foodRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        foodAdapter = FoodAdapter(yemekListesi) { yemek ->
            val intent = Intent(this, FoodDetailActivity::class.java).apply {
                putExtra("yemekAdi", yemek.isim)
                putExtra("malzemeler", yemek.malzemeler)
                putExtra("tarif", yemek.tarif)
                putExtra("resim", yemek.resim)
            }
            startActivity(intent)
        }
        recyclerView.adapter = foodAdapter

        supportActionBar?.apply {
            title = "Yemek Listesi"
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addFood -> {
                val dialog = AddFoodDialog(this) { yeniYemek ->
                    yemekListesi.add(yeniYemek)
                    foodAdapter.notifyDataSetChanged()
                    Toast.makeText(this, "Yemek eklendi: ${yeniYemek.isim}", Toast.LENGTH_SHORT).show()
                }
                dialog.show()
                return true
            }
            R.id.playGame -> {
                val intent = Intent(this, GameActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        // Kullanıcı giriş ekranına dönmek için intent oluşturuyoruz
        val intent = Intent(this, LoginActivity::class.java).apply {
            putExtra("clearFields", true)
        }
        startActivity(intent)
        finish()


        super.onBackPressed()
    }

}
