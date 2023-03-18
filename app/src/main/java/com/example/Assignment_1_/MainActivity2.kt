package com.example.Assignment_1_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ass1.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var arr = ArrayList<data_class>()
        list_user.layoutManager = LinearLayoutManager(this)
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    arr.add(data_class(document.data.get(key = "name") as String, document.data.get(key = "number") as String, document.data.get(key = "address") as String))
                    list_user.adapter = adapter(this, arr)
                    Log.d("sss" , arr.toString())
                }
            }
    }
}