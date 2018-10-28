package com.example.mjcan.mainkey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        //Takes user back to home screen
        val savebtn : Button = findViewById(R.id.saveButton)
        savebtn.setOnClickListener {
            val intent_home = Intent(this, Home::class.java)
            startActivity(intent_home)
        }
    }
}
