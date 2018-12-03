package com.example.mjcan.mainkey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

/*
    App home page, all the accounts are visible
    It has the option to logout or to add another account to store
 */

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val uid = FirebaseAuth.getInstance().uid ?: ""
        var db : FirebaseFirestore = FirebaseFirestore.getInstance()

        val ref = db
                .collection("users")
                .document(uid)
                .collection("accounts")

        ref.get().addOnCompleteListener {task ->
            if (task.isSuccessful){
                val list = ArrayList<String>()
                for (document in task.result!!){
                    val name = document.data["Account Name"].toString()
                    list.add(name)
                }
                val accountsList : ListView = findViewById(R.id.listView)
                val adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
                accountsList.adapter = adapter
            }
        }

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


