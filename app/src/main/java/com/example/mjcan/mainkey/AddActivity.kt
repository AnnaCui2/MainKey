package com.example.mjcan.mainkey

import android.accounts.Account
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.System.exit

/*
    Add new accounts (entries) to be stored by the app
 */


var count: Int = 0

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        //Takes user back to home screen
        val savebtn : Button = findViewById(R.id.saveButton)
        savebtn.setOnClickListener {

            var accName = findViewById<EditText>(R.id.accountName).getText().toString()
            var accLogin = findViewById<EditText>(R.id.accountEmail).getText().toString()
            var accPassword = findViewById<EditText>(R.id.accountPassword).getText().toString()
            val newItem = AccountInfo(accName, accLogin, accPassword, count)

            Toast.makeText( applicationContext, "count" + newItem.ID, Toast.LENGTH_LONG).show()

            count += 1
            val intent_home = Intent(this, Home::class.java)
            startActivity(intent_home)
        }





    }
}
