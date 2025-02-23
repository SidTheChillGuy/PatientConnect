package com.epics.patientconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var passwordConfirmText: EditText
    private lateinit var usermailid: EditText
    private lateinit var createaccountbutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize views
        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        passwordConfirmText = findViewById(R.id.passwordconfirm)
        createaccountbutton = findViewById(R.id.createaccountbutton)
        usermailid = findViewById(R.id.usermailid)

        // Set click listener for the login button
        createaccountbutton.setOnClickListener {
            performAccountCreation()
        }
    }

    private fun performAccountCreation() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val passconfirm = passwordConfirmText.text.toString()
        val mailid = usermailid.text.toString()

        // Here you would typically validate the username and password
        // For demonstration, let's assume a simple check
        if (username.isEmpty() || password.isEmpty() || passconfirm.isEmpty() || mailid.isEmpty()) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show()
            return
        }

        if (password != passconfirm)
        {
            Toast.makeText(this,"Password and confirmation fields do not match!", Toast.LENGTH_LONG).show()
            return
        }

        // TODO: Implement actual authentication logic (e.g., API call)

        // For demonstration, let's assume successful login
        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

        // Navigate to the main app screen after successful login
        val intent = Intent(this, MainActivity::class.java) // Replace with your main app activity
        startActivity(intent)
        finish() // Close the login activity
    }
}