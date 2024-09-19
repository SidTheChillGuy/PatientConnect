package com.epics.patientconnect

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.WelcomeScreen)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // define buttons actions
        val UserLoginButton: Button = findViewById(R.id.UserLoginbutton)
        val AdminLoginButton: Button = findViewById(R.id.AdminLoginButton)
        val UserLandingButton: Button = findViewById(R.id.temporary_userlanding)

        UserLoginButton.setOnClickListener {
            Toast.makeText(this, "User Login Clicked", Toast.LENGTH_LONG).show()
        }

        AdminLoginButton.setOnClickListener {
            Toast.makeText(this, "Admin Login Clicked", Toast.LENGTH_LONG).show()
        }

        UserLandingButton.setOnClickListener{
            val intent = Intent(this, UserLandingPage::class.java)
            startActivity(intent)
        }




    }
}