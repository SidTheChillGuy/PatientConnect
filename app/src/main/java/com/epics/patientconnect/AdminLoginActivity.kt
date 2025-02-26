package com.epics.patientconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminLoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var secretKeyEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var notAdminLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        // Initialize views
        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        secretKeyEditText = findViewById(R.id.SecretKey)

        loginButton = findViewById(R.id.login_button)
        notAdminLink = findViewById(R.id.notadmin_link)

        // Set click listener for the login button
        loginButton.setOnClickListener {
            performLogin()
        }

        // Set click listener for the signup link
        notAdminLink.setOnClickListener {
            // Navigate to Sign Up Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performLogin() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val secretkey = secretKeyEditText.text.toString()

        // Here you would typically validate the username and password
        // For demonstration, let's assume a simple check
        if (username.isEmpty() || password.isEmpty() || secretkey.isEmpty()) {
            Toast.makeText(this, "Please enter username, password and SecretKey correctly!", Toast.LENGTH_LONG).show()
            return
        }

        // TODO: Implement actual authentication logic (e.g., API call)
        if(username=="admin" && password=="admin" && secretkey=="secret") {
            // For demonstration, let's assume successful login
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

            // Navigate to the main app screen after successful login
            val intent =
                Intent(this, LandingAdminPage::class.java) // Replace with your main app activity
            startActivity(intent)
        }
        finish() // Close the login activity
    }
}