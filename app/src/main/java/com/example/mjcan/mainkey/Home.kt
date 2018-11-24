package com.example.mjcan.mainkey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView


/*
    App home page, all the accounts are visible
    It has the option to logout or to add another account to store
 */


//Example list entries to show functionality
val items = arrayOf("Facebook", "Snapchat", "Instagram", "reddit", "Yahoo", "Spotify",
        "Discord", "Twitch", "Chegg", "PayPal", "Steam", "Apple", "Netflix",
        "Bank", "Canvas", "Slack")

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Loads example list to home screen listView
        //CHANGE TO FETCH FROM DATABASE
        val accountsList : ListView = findViewById(R.id.listView)
        val adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,items)
        accountsList.adapter = adapter

        //Sends user to add entry screen on button press
        val logoutbtn : Button = findViewById(R.id.logoutbtn)
        logoutbtn.setOnClickListener {
            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)
        }
        //Sends user to add entry screen on button press
        val addbtn : Button = findViewById(R.id.addbtn)
        addbtn.setOnClickListener {
            val intent = Intent(this, AddActivity :: class.java)
            startActivity(intent)
        }
    }
}