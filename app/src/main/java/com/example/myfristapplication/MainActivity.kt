package com.example.myfristapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val email = findViewById<EditText>(R.id.etUserEmail)
        val password = findViewById<EditText>(R.id.etUserPassword)


        findViewById<Button>(R.id.btnSubmitLogin).setOnClickListener {
            // write logic to handle the button
            var submittedEmail = email.text.toString()
            var submittedPassword = password.text.toString()

            // TODO: Create the logic to verify user login details, EMAIL should be valid, Password must have 8 length including small/capital letters with digit and special characters

            //email should be valid
            submittedEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
            println(submittedEmail.toRegex())

            //password
            if (submittedPassword.length < 8) {
                println("The password must be at least 8 characters long.")

            }

            var hasUpper = false
            var hasLower = false
            var hasDigit = false
            var hasSpecial = false

            for (char in submittedPassword) {
                when {
                    char.isUpperCase() -> hasUpper = true
                    char.isLowerCase() -> hasLower = true
                    char.isDigit() -> hasDigit = true
                    !char.isLetterOrDigit() -> hasSpecial = true
                }
            }

            if (!hasUpper || !hasLower || !hasDigit || !hasSpecial) {
                println("The password must contain small/capital letters with digit and special characters")
            }

            println("Password setup successfully.")
        }




        }
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            //val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            //v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            //insets
       // }
    }
