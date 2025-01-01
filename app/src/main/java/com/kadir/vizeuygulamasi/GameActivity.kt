package com.kadir.vizeuygulamasi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {

    private val kelimeListesi = listOf("TELEFON", "TAHTA", "MUZ", "KARPUZ", "KART", "TARTI", "KLAVYE", "YORGAN", "ARABA", "KALEM", "DEFTER", "ELMA", "MASA", "SANDALYE")
    private var mevcutKelime = ""
    private var puan = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val harflerTextView: TextView = findViewById(R.id.harflerTextView)
        val kelimeEditText: EditText = findViewById(R.id.kelimeEditText)
        val kontrolButton: Button = findViewById(R.id.kontrolButton)
        val gecButton: Button = findViewById(R.id.gecButton)
        val puanTextView: TextView = findViewById(R.id.puanTextView)


        yeniKelime(harflerTextView)

        kontrolButton.setOnClickListener {
            val girilenKelime = kelimeEditText.text.toString().uppercase()

            if (girilenKelime == mevcutKelime) {
                val harfSayisi = mevcutKelime.length
                puan += harfSayisi // Harf sayısına göre puan ekleniyor
                Toast.makeText(this, "Doğru! $harfSayisi puan kazandınız. Yeni kelimeye geçiliyor.", Toast.LENGTH_SHORT).show()
                kelimeEditText.text.clear()
                yeniKelime(harflerTextView)
            } else {
                Toast.makeText(this, "Yanlış! Tekrar deneyin.", Toast.LENGTH_SHORT).show()
            }


            puanTextView.text = "Puan: $puan"
        }

        gecButton.setOnClickListener {
            Toast.makeText(this, "Geçildi! Yeni kelimeye geçiliyor.", Toast.LENGTH_SHORT).show()
            kelimeEditText.text.clear()
            yeniKelime(harflerTextView) // Yeni kelimeyi başlat
        }
    }

    private fun yeniKelime(harflerTextView: TextView) {
        mevcutKelime = kelimeListesi.random()
        val karisikHarfler = mevcutKelime.toCharArray().apply { shuffle() }.joinToString(" ")
        harflerTextView.text = "Harfler: $karisikHarfler"
    }
}
