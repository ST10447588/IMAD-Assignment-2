package com.example.pet

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets }

            class MainActivity : AppCompatActivity() {
                private lateinit var petImageView: ImageView
                private var health: Int = 100
                private var hunger: Int = 0
                private var cleanliness: Int = 100

                override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)
                    setContentView(R.layout.activity_main)

                 val petImageView = findViewById<ImageView>(R.id.petImageView)

                    val feedButton: Button = findViewById<Button>(R.id.feedButton)
                    val cleanButton: Button = findViewById<Button>(R.id.cleanButton)
                    val playButton: Button = findViewById<Button>(R.id.playButton)

                    feedButton.setOnClickListener {
                        feedPet()
                        updatePetStatus()
                    }

                    cleanButton.setOnClickListener {
                        cleanPet()
                        updatePetStatus()
                    }

                    playButton.setOnClickListener {
                        playWithPet()
                        updatePetStatus()
                    }
                }

                private fun feedPet() {
                    // Logic for feeding the pet
                    // For simplicity, just increment hunger and decrease health
                    hunger -= 10
                    if (hunger < 0) hunger = 0
                    health += 5
                    if (health > 100) health = 100
                    // Update pet image here to reflect feeding action
                    petImageView.setImageResource(R.drawable.fedpet)
                }

                private fun cleanPet() {
                    // Logic for cleaning the pet
                    // For simplicity, just decrease cleanliness
                    cleanliness -= 20
                    if (cleanliness < 0) cleanliness = 0
                    // Update pet image here to reflect cleaning action
                    petImageView.setImageResource(R.drawable.cleanpet)
                }

                private fun playWithPet() {
                    // Logic for playing with the pet
                    // For simplicity, just decrease health and increase happiness
                    health -= 10
                    if (health < 0) health = 0
                    // Update pet image here to reflect playing action
                    petImageView.setImageResource(R.drawable.playWithpet)
                }

                private fun updatePetStatus() {
                    // Update UI elements to reflect pet's status
                    // For simplicity, just display health, hunger, and cleanliness values
                    Toast.makeText(
                        this,
                        "Health: $health, Hunger: $hunger, Cleanliness: $cleanliness",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
}