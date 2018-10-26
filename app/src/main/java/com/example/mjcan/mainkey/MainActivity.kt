package com.example.mjcan.mainkey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn.setOnClickListener {
            var statues =
                if (username_et.text.toString().equals("Sample") && password_et.text.toString().equals("password")) "Logged in"
                else
                    "Login fail"


        }

        //Sends to user to home screen on button press
        val loginbtn : Button = findViewById(R.id.login_btn)
        loginbtn.setOnClickListener{
            val intent = Intent(this,Home :: class.java)
            startActivity(intent)
        }
    }
}