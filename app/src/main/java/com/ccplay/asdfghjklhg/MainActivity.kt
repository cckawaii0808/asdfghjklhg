package com.ccplay.asdfghjklhg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.ActionMenuView
import com.ccplay.asdfghjklhg.databinding.ActivityMainBinding


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.signup.setOnClickListener {
            val email = binding.TVemail.text.toString()
            val password = binding.tvpassword.text.toString()
            Log.d(TAG,"使用者帳號:$email 使用者密碼: $password")
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "註冊成功")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "註冊失敗", task.exception)
                        Toast.makeText(
                            baseContext, "註冊失敗.",
                            Toast.LENGTH_SHORT
                        ).show()
                        //  updateUI(null)
                    }
                }
        }
    }
    private fun updateUI(user: FirebaseUser?) {
        Toast.makeText(
            baseContext, "畫面轉換",
            Toast.LENGTH_SHORT
        ).show()
    }
}