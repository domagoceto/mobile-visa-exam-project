package com.kadir.vizeuygulamasi

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val countdownTextView: TextView = findViewById(R.id.countdownTextView)


        object : CountDownTimer(7000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                countdownTextView.text = "Kalan süre: $secondsRemaining saniye"
            }

            override fun onFinish() {
                // Süre dolduğunda LoginActivity'e yönlendirme
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }

    override fun onBackPressed() {

        finishAffinity()

        super.onBackPressed()
    }
}
