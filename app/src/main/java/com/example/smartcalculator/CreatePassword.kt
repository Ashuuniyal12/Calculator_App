package com.example.smartcalculator

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smartcalculator.R

class CreatePassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_password)
    }

    fun checkForPassword(view: View) {

        var passwordA: EditText = findViewById(R.id.enterPassword)
        var passwordB: EditText = findViewById(R.id.enterPasswordagain)

        var originalPassword: String = passwordA.getText().toString()
        var confirmPassword: String = passwordB.getText().toString()

        if (originalPassword == "" || confirmPassword == "")
        {
            val toast = Toast.makeText(this, "Enter a valid password", Toast.LENGTH_SHORT).show()
        }
        if (originalPassword.equals(confirmPassword)) {
            //Set up the password
            var settings: SharedPreferences = getSharedPreferences("PRESS", 0)
            var editor: SharedPreferences.Editor = settings.edit()
            editor.putString("password", originalPassword)
            editor.apply()
            startActivity(Intent(this, EnterPassword::class.java))

            //enter the secret folder
                startActivity(Intent(this, Gallary::class.java))
        }
        else
        {
            var toast = Toast.makeText(this, "Password Does not match", Toast.LENGTH_SHORT).show()
        }

    }
}
