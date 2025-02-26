package com.epics.patientconnect

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class UserLoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var signupLink: TextView
    private lateinit var togglePasswordVisibility: ImageView
    private lateinit var loadingProgress: ProgressBar
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        // Initialize views
        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.login_button)
        signupLink = findViewById(R.id.signup_link)
        togglePasswordVisibility = findViewById(R.id.toggle_password_visibility)
        loadingProgress = findViewById(R.id.loading_progress)

        // Login Button Click
        loginButton.setOnClickListener {
            performLogin()
        }

        // Signup Link Click
        signupLink.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        // Password Toggle Click
        togglePasswordVisibility.setOnClickListener {
            togglePassword()
        }
    }

    private fun performLogin() {
        val username = usernameEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (username.isEmpty() || password.isEmpty()) {
            showToast("Please enter both username and password")
            return
        }

        // Show Progress Bar & Disable Button
        loadingProgress.visibility = View.VISIBLE
        loginButton.isEnabled = false

        usernameEditText.postDelayed({
            // Hide Progress Bar & Enable Button
            loadingProgress.visibility = View.GONE
            loginButton.isEnabled = true

            if (username == "admintest" && password == "admintest") {
                showToast("Login Successful!")
                startActivity(Intent(this, LandingUserPage::class.java))
                finish()
            } else {
                showToast("Invalid credentials, please try again!")
            }
        }, 1500) // Simulated API delay
    }

    private fun togglePassword() {
        isPasswordVisible = !isPasswordVisible
        if (isPasswordVisible) {
            passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            togglePasswordVisibility.setImageResource(R.drawable.ic_eye_open) // Now correctly referenced
        } else {
            passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            togglePasswordVisibility.setImageResource(R.drawable.ic_eye_closed) // Now correctly referenced
        }
        passwordEditText.setSelection(passwordEditText.text.length) // Maintain cursor position
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}


