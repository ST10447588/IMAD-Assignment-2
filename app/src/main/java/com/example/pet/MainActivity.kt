package com.example.pet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var Tv1 = findViewById<TextView>(R.id.Tv1).text
        var Iv2 = this.findViewById<ImageView>(R.id.Iv1)
        var Btn1 = findViewById<Button>(R.id.Btn1)

        // Set up the welcome screen
        Btn1.setOnClickListener {
            // Create an Intent to start SecondScreenActivity
            val intent = Intent(this, MainActivity2::class.java)
            // Start SecondScreenActivity
            startActivity(intent)
        }
    }
}


