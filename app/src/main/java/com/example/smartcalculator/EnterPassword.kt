package com.example.smartcalculator

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smartcalculator.Gallary
import com.example.smartcalculator.R

class EnterPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_password)
    }

    fun comparePasswords(view: View) {
        var password: String? = null
        var passwordtoComparer: EditText = findViewById(R.id.checkpass)
        var text: String = passwordtoComparer.getText().toString()

        var setting: SharedPreferences = getSharedPreferences("PRESS", 0)
        password = setting.getString("password", "").toString()
        //compare enterd password with original
        if (text.equals(password)) {
            //enter the app
                startActivity(Intent(this, Gallary::class.java))
            }
        else{
            Toast.makeText(this, "Wrong Password!", Toast.LENGTH_SHORT).show()
        }

        }
    }