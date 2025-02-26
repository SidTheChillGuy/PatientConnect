package com.epics.patientconnect

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class LandingAdminPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_admin_page)

        val button1: Button = findViewById(R.id.editmedicalhistbtn)

        button1.setOnClickListener(){
            Toast.makeText(this, "Function Not mplemented yet", Toast.LENGTH_SHORT).show()
        }
    }
}