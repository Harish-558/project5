package com.example.projectharish8

import android.widget.TextView
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

// Find the TextView in onCreate
        val tvRegister = findViewById<TextView>(R.id.tvRegister)
        tvRegister.setOnClickListener {
            // This moves the user from Login to Registration
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val emailLayout = findViewById<TextInputLayout>(R.id.emailLayout)
        val passwordLayout = findViewById<TextInputLayout>(R.id.passwordLayout)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)

        btnLogin.setOnClickListener {
            emailLayout.error = null
            passwordLayout.error = null

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // 1. Check if Email is Empty
            if (email.isEmpty()) {
                emailLayout.error = "Email cannot be empty"
            }
            // 2. Check if Email is Valid
            else if (!email.contains("@")) {
                emailLayout.error = "Please enter a valid email address"
            }
            // 3. Check Password Length
            else if (password.length < 6) {
                passwordLayout.error = "Password must be at least 6 characters"
            }
            // 4. EVERYTHING IS CORRECT (Only one 'else' here!)
            else {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

                // Move to WelcomeActivity
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("USER_EMAIL", email)
                startActivity(intent)

                // Close Login screen
                finish()
            }
        }
    }
}