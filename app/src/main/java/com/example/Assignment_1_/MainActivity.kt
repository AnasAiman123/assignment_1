package com.example.Assignment_1_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.ass1.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore

    // @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add_user.setOnClickListener {
            val user = hashMapOf(
                "name" to name_user.text.toString(),
                "number" to number_user.text.toString(),
                "address" to address_user.text.toString()
            )

            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d("TAG", "DocumentSnapshot add with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("TAG", "Error add document", e)
                }

        }
        view_user.setOnClickListener {
            var i = Intent(this , MainActivity2 :: class.java)
            startActivity(i)
        }

    }
}