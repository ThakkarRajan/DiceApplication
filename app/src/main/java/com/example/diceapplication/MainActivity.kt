package com.example.diceapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.diceapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btnRoll = binding.btnRoll
        btnRoll.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        val resultdice = binding.resultDice
        val randomVal = Random.nextInt(6)+1

        val diceImage = when (randomVal) {
            1 -> "one"
            2 -> "two"
            3 -> "three"
            4 -> "four"
            5 -> "five"
            else -> "six"
        }

// Usage example
        val resourceId = getDrawableResourceId(diceImage)

        resultdice.setImageResource(resourceId)
    }
    @SuppressLint("DiscouragedApi")
    fun getDrawableResourceId(resourceName: String): Int {
        return resources.getIdentifier(resourceName, "mipmap", packageName)
    }

}


