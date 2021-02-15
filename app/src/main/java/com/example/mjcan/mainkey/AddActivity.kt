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
import com.google.firebase.auth.FirebaseAuth
import java.lang.System.exit
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add.accountName
import kotlinx.android.synthetic.main.activity_add.accountEmail
import kotlinx.android.synthetic.main.activity_add.accountPassword

/*
    Add new accounts (entries) to be stored by the app
 */

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        //Takes user back to home screen
        val savebtn : Button = findViewById(R.id.saveButton)
        savebtn.setOnClickListener {
            performAdd()
        }
    }

    private fun performAdd(){
        //Receive account information
        val accName : String = accountName.text.toString()
        val accEmail : String = accountEmail.text.toString()
        val accPassword : String = accountPassword.text.toString()

        if (accName.isEmpty() || accEmail.isEmpty() || accPassword.isEmpty()){
            Toast.makeText(this, "Please enter text in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d(TAG, "Account name is: " + accName)
        Log.d(TAG, "Email is " + accEmail)
        Log.d(TAG, "Password:: $accPassword")

        val uid = FirebaseAuth.getInstance().uid ?: ""
        var db : FirebaseFirestore = FirebaseFirestore.getInstance()

        val items = HashMap<String, Any>()
        items.put("Account Name", accName)
        items.put("Email", accEmail)
        items.put("Password", accPassword)

        val ref = db
                .collection("users")
                .document(uid)
                .collection("accounts")
                .document(accName)
                .set(items)

        val intent_home = Intent(this, Home::class.java)
        startActivity(intent_home)
    }
}

private val TAG = AddActivity::class.java.getName()