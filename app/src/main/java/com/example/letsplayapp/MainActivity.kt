package com.example.letsplayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name = findViewById<TextView>(R.id.textView)

        auth = FirebaseAuth.getInstance()

        val user = Firebase.auth.currentUser?.email
        if (user != null) {
                    name.text = "You're $user"
        } else {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }


        val buttonLogout = findViewById<Button>(R.id.LogoutButton)
        buttonLogout.setOnClickListener {
            Firebase.auth.signOut()
//            finish()
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }
}