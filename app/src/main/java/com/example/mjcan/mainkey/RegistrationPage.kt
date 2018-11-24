package com.example.mjcan.mainkey

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.activity_registration_page.input_email
import kotlinx.android.synthetic.main.activity_registration_page.input_password
import kotlinx.android.synthetic.main.activity_registration_page.btn_signup



/*
    Page where the user creates an Admin account,
    to login into the app and have access to the added accounts
 */

class RegistrationPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)

        //Create account button
        val signupbtn : Button = findViewById(R.id.btn_signup)

        signupbtn.setOnClickListener {
            performRegister()
            val intent_main = Intent(this, MainActivity::class.java)
            startActivity(intent_main)
        }
    }

    private fun performRegister(){
        val email : String = input_email.text.toString()
        val password : String = input_password.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter text in email/password", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d(TAG,"Email is: " + email)
        Log.d(TAG,"Password:: $password")

        //Firebase Authentication to create a user with email and password
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).
                addOnCompleteListener{
                    if (!it.isSuccessful) {
                        return@addOnCompleteListener
                    }
                    //else if successful

                    //Store user in Firebase
                    var db : FirebaseFirestore = FirebaseFirestore.getInstance()
                    val uid = FirebaseAuth.getInstance().uid ?: ""

                    val items = HashMap<String, Any>()
                    items.put("Email", email)

                    db.collection("users").document(uid).set(items)
                    Log.d(TAG, "Sumjccessfully created user with uid: ${it.result?.user?.uid}")
                }
                .addOnFailureListener{
                    Log.d(TAG, "Failed to create user account: ${it.message}")
                    Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT).show()
                }

    }
}

class User(val uid: String, val adminEmail: String)


private val TAG = RegistrationPage::class.java.getName()