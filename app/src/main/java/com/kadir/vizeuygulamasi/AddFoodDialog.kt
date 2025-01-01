package com.kadir.vizeuygulamasi.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.kadir.vizeuygulamasi.R
import com.kadir.vizeuygulamasi.models.Yemek

class AddFoodDialog(
    context: Context,
    private val onFoodAdded: (Yemek) -> Unit
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_food)

        val foodNameEditText = findViewById<EditText>(R.id.foodNameEditText)
        val foodIngredientsEditText = findViewById<EditText>(R.id.foodIngredientsEditText)
        val foodRecipeEditText = findViewById<EditText>(R.id.foodRecipeEditText)
        val saveButton = findViewById<Button>(R.id.saveFoodButton)
        val cancelButton = findViewById<Button>(R.id.cancelButton)

        saveButton.setOnClickListener {
            val foodName = foodNameEditText.text.toString()
            val foodIngredients = foodIngredientsEditText.text.toString()
            val foodRecipe = foodRecipeEditText.text.toString()

            if (foodName.isNotEmpty() && foodIngredients.isNotEmpty() && foodRecipe.isNotEmpty()) {
                val yeniYemek = Yemek(
                    isim = foodName,
                    malzemeler = foodIngredients,
                    tarif = foodRecipe,
                    resim = R.drawable.sample_food
                )
                onFoodAdded(yeniYemek) // Yeni yemek ekleme işlemi
                dismiss() //
            } else {
                Toast.makeText(context, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show()
            }
        }

        cancelButton.setOnClickListener {
            dismiss()
        }
    }
}

