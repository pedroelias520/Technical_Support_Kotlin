package com.example.alphatechapp

import Model.User
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

private lateinit var database: DatabaseReference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Firebase.database.reference

        fun writeNewUser(userId:String, name:String, email: String){
            val user = User(name, email)
            database.child("users").child(userId).setValue(user)
        }

        fun getDataUser(userId:String){
            database.child("users").child(userId).get().addOnSuccessListener {
                Log.i("firebase", "Got value ${it.value}")
            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
            }
        }

        getDataUser("1Wy97BJB3gBuaTsJlpla")

    }
}