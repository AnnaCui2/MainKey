package com.example.mjcan.mainkey

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.email_et
import kotlinx.android.synthetic.main.activity_main.password_et


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val loginbtn : Button = findViewById(R.id.login_btn)
        loginbtn.setOnClickListener{
            performLogin()
        }
        
        //Takes user to registration page
        val registerbtn : Button = findViewById(R.id.register_btn)
        registerbtn.setOnClickListener {
            val intent_register = Intent(this,RegistrationPage :: class.java)
            startActivity(intent_register)
        }
    }
    
    private fun performLogin(){
        val email : String = email_et.text.toString()
        val password : String = password_et.text.toString()
        
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter text in email/password", Toast.LENGTH_SHORT).show()
            return
        }
        
        Log.d(TAG,"Email is: " + email)
        Log.d(TAG,"Password:: $password")
        
        //Firebase Authentication to sign in with email and password
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).
                addOnCompleteListener{
                    if (it.isSuccessful){
                        Log.d(TAG,"Successfully signed in!")
                        
                        //Sends to user to home screen on button press
                        val intent_login = Intent(this,Home :: class.java)
                        startActivity(intent_login)
                        return@addOnCompleteListener
                    }
                }
                .addOnFailureListener{
                    Log.w(TAG, "Sign in failed.")
                    Toast.makeText(baseContext, "Invalid credentials.", Toast.LENGTH_SHORT).show()
                }
    }
}

private val TAG = MainActivity::class.java.getName()
