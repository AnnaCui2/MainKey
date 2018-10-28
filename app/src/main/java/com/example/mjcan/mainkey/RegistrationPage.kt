package com.example.mjcan.mainkey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistrationPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)

        val signupbtn : Button = findViewById(R.id.btn_signup)
        signupbtn.setOnClickListener {
            val intent_main = Intent(this, MainActivity::class.java)
            startActivity(intent_main)
        }
    }
}
