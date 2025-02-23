package com.epics.patientconnect
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link buttons
        val userLoginButton: Button = findViewById(R.id.user_login)
        val adminLoginButton: Button = findViewById(R.id.admin_login)
        val signUpButton: Button = findViewById(R.id.sign_up)

        // Set click listeners
        userLoginButton.setOnClickListener {
            // Navigate to User Login Activity
            val intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
        }

        adminLoginButton.setOnClickListener {
            // Navigate to Admin Login Activity
            val intent = Intent(this, AdminLoginActivity::class.java)
            startActivity(intent)
        }

        signUpButton.setOnClickListener {
            // Navigate to Sign Up Activity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}