package com.kadir.vizeuygulamasi

import android.os.Bundle
import android.app.Activity // AppCompatActivity yerine Activity kullanılıyor

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
