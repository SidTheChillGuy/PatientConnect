package com.epics.patientconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LandingUserPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_user_page)

        val button1: Button = findViewById(R.id.medicalhistbtn)
        val button2: Button = findViewById(R.id.uploadreportsbtn)
        val button3: Button = findViewById(R.id.findhospitalsbtn)

        button1.setOnClickListener {
            showmedicalhist()
        }

        button2.setOnClickListener {
            uploadreports()
        }

        button3.setOnClickListener {
            findhospitals()
        }
    }
    private fun showmedicalhist()
    {
        val medhist = Intent(this, UserHistoryPage::class.java)
        startActivity(medhist)
    }
    private fun uploadreports()
    {
        Toast.makeText(this, "UploadReports Not Implemented", Toast.LENGTH_LONG).show()
    }
    private fun findhospitals()
    {
        Toast.makeText(this, "FindHospitals not Implemented", Toast.LENGTH_LONG).show()
    }
}