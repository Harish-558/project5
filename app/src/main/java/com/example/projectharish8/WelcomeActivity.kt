package com.example.projectharish8

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Get the Email passed from MainActivity
        val userEmail = intent.getStringExtra("USER_EMAIL")
        val tvUserEmail = findViewById<TextView>(R.id.tvUserEmail)

        // 2. Display the email
        tvUserEmail.text = "Logged in as: $userEmail"

        // 3. Handle Logout Button
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            // Go back to Login Screen
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Close this screen
            finish()
        }
    }
}