package com.example.charitable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.charitable.fragments.HomeScreen
import com.example.charitable.fragments.Login

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, Login())
            commit()
    }
    }
}