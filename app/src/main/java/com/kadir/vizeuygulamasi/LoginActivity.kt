package com.kadir.vizeuygulamasi

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val USERNAME = "KadirCetin"
    private val PASSWORD = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val rememberMeCheckBox: CheckBox = findViewById(R.id.rememberMeCheckBox)
        val loginButton: Button = findViewById(R.id.loginButton)

        val sharedPreferences: SharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)

        // Intent'ten gelen clearFields bilgisini kontrol et
        val clearFields = intent.getBooleanExtra("clearFields", false)
        if (clearFields) {
            usernameEditText.setText("")
            passwordEditText.setText("")
            rememberMeCheckBox.isChecked = sharedPreferences.getBoolean("rememberMe", false)
        } else {
            //
            if (sharedPreferences.getBoolean("rememberMe", false)) {
                usernameEditText.setText(sharedPreferences.getString("username", ""))
                passwordEditText.setText(sharedPreferences.getString("password", ""))
                rememberMeCheckBox.isChecked = true
            }
        }

        loginButton.setOnClickListener {
            val enteredUsername = usernameEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()
            val rememberMe = rememberMeCheckBox.isChecked

            if (enteredUsername == USERNAME && enteredPassword == PASSWORD) {
                val editor = sharedPreferences.edit()

                if (rememberMe) {
                    editor.putBoolean("rememberMe", true)
                    editor.putString("username", enteredUsername)
                    editor.putString("password", enteredPassword)
                } else {
                    editor.clear() // Tüm verileri temizle
                }
                editor.apply()

                Toast.makeText(this, "Başarılı giriş!", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, FoodListActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Hatalı giriş
                Toast.makeText(this, "Kullanıcı adı veya şifre hatalı!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        // SplashActivity'ye dönmek için intent oluşturuyoruz
        val intent = Intent(this, SplashActivity::class.java).apply {
            putExtra("clearFields", true)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
        finish() //

        super.onBackPressed()
    }
}
