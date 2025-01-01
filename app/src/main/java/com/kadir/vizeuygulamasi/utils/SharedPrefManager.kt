package com.kadir.vizeuygulamasi.utils

import android.content.Context

class SharedPrefManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("AppPref", Context.MODE_PRIVATE)

    fun saveLoginInfo(username: String, password: String) {
        sharedPreferences.edit().apply {
            putString("username", username)
            putString("password", password)
            apply()
        }
    }

    fun getLoginInfo(): Pair<String?, String?> {
        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)
        return Pair(username, password)
    }

    fun clearLoginInfo() {
        sharedPreferences.edit().clear().apply()
    }
}
