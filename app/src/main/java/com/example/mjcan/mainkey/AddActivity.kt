package com.example.mjcan.mainkey

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

var tempAcc: AccountInfo? = null
var accName: String? = null
var accLogin: String? = null
var accPassword: String? = null


class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        //Takes user back to home screen
        val savebtn : Button = findViewById(R.id.saveButton)
        savebtn.setOnClickListener {
            accName = findViewById<EditText>(R.id.accountName).toString()
            accLogin = findViewById<EditText>(R.id.accountEmail).toString()
            accPassword = findViewById<EditText>(R.id.accountPassword).toString()


            tempAcc?.initNode(accName!!, accLogin!!, accPassword!!)


            val intent_home = Intent(this, Home::class.java)
            startActivity(intent_home)
        }





    }
}
