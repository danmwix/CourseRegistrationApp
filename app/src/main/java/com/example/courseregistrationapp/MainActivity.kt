package com.example.courseregistrationapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinnerCourse)
        val editStudentId = findViewById<EditText>(R.id.editTextStudentId)
        val btnRegister = findViewById<Button>(R.id.buttonRegister)

        val courses = listOf(
            // Year 1 Semester 1
            "SCS3101 - Introduction to Computer Systems",
            "SCS3103 - Introduction to Programming",
            "SCS3105 - Discrete Maths",
            "SCS3107 - Programming Lab",
            "SPH3105 - Physics for Computing Systems",

            // Year 1 Semester 2
            "SCS3102 - Database Systems",
            "SCS3104 - Data Communication",
            "SMA3211 - Linear Algebra",
            "SCS3106 - Object-Oriented Programming",
            "SCS3108 - Data Structures and Algorithms",
            "SCS3109 - Digital Electronics",

            // Year 2 Semester 1
            "SMA3114 - Differential and Integral Calculus",
            "SCS3201 - Systems Analysis and Design",
            "SCS3203 - Computer Architecture",
            "SCS3205 - Knowledge-based Systems & Programming",
            "SCS3207 - Operating Systems",
            "SCS3209 - Software Engineering",
            "SCS3211 - Computer Networks",

            // Year 2 Semester 2
            "SMA3124 - Probability and Statistics",
            "SCS3202 - Assembly Language Programming",
            "SCS3204 - Automata Theory",
            "SCS3206 - Programming Project",
            "SCS3208 - Web and Services Programming",
            "SCS3212 - Machine Learning Algorithms & Programming",
            "SCS3214 - Foundations of Human-Computer Interaction",

            // Year 3 Semester 1
            "SCS3213 - Analysis and Design of Algorithms",
            "SCS3301 - Computer Graphics",
            "SCS3303 - Distributed Systems",
            "SCS3305 - Introduction to Organizations and Management",
            "SCS3307 - Artificial Intelligence Applications",
            "SCS3309 - Network Design Implementation and Management",
            "SCS3311 - Innovation & Entrepreneurship",

            // Year 3 Semester 2
            "SCS3302 - ICT Project Management",
            "SCS3304 - Network and Distributed Programming",
            "SCS3306 - Compiler Construction",
            "SCS3308 - Embedded Systems & Mobile Programming",
            "SCS3312 - Business Intelligence & Analytics",
            "SCS3314 - Computer Network Security",

            // Year 3 Semester 3
            "SCS3322 - Industrial Attachment",

            // Year 4 Semester 1
            "SCS3401 - ICTs and Society",
            "SCS3403 - Computer Systems Project",
            "SCS3405 - Information Systems and Organizations",
            "SCS3407 - Emerging Technologies Bootcamps",
            "SCS3409 - Distributed Databases",
            "SCS3411 - Computer Games Programming",

            // Year 4 Semester 2
            "SCS3402 - Cloud Computing and Services",
            "SCS3404 - Information Systems Control and Audit",
            "SCS3406 - Informatics for Emerging Online",
            "SCS3403 - Project"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            courses
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btnRegister.setOnClickListener {
            val studentId = editStudentId.text.toString().trim()

            if (studentId.isEmpty()) {
                editStudentId.error = "Please enter your Student ID"
                return@setOnClickListener
            }

            val selectedCourse = spinner.selectedItem.toString()

            val intent = Intent(this, ConfirmationActivity::class.java)
            intent.putExtra("STUDENT_ID", studentId)
            intent.putExtra("COURSE", selectedCourse)
            startActivity(intent)
        }
    }
}