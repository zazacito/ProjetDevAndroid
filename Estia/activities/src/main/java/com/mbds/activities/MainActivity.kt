package com.mbds.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private lateinit var textViewButton: TextView
    private lateinit var computeButton: Button
    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initialisation du bouton et de la text view
        clickButton = findViewById(R.id.btn_click_me)
        textViewButton = findViewById(R.id.text_view_button)
        computeButton = findViewById(R.id.btn_compute)
        clickButton.setOnClickListener {
            nbClick++
            val newText = "Vous avez cliqué $nbClick fois"
            textViewButton.text = newText
            if (nbClick > 4){
                clickButton.isEnabled = false
            }
        }
        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActiviy::class.java)
            startActivity(intent)
        }
    }


}