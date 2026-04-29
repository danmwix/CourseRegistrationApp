package com.example.courseregistrationapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        // 1. Retrieve data passed from MainActivity
        val studentId = intent.getStringExtra("STUDENT_ID") ?: "Unknown"
        val course    = intent.getStringExtra("COURSE")    ?: "Unknown"

        // 2. Display confirmation message
        val tvConfirm = findViewById<TextView>(R.id.textViewConfirmation)
        tvConfirm.text =
            "Registration Successful!\n\n" +
                    "Student ID: $studentId\n\n" +
                    "Course: $course"

        // 3. Back button
        val btnBack = findViewById<Button>(R.id.buttonBack)
        btnBack.setOnClickListener {
            finish()   // closes this activity and returns to MainActivity
        }
    }
}