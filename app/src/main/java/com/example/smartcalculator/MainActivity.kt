package com.example.smartcalculator

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smartcalculator.CreatePassword
import com.example.smartcalculator.EnterPassword
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    var stringNumber = " "


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun numberEvent(view: View) {
        val output: TextView = findViewById(R.id.output)
        var screen: TextView = findViewById(R.id.screen)
        val zero = findViewById<Button>(R.id.zero)
        zero.setOnClickListener {
            stringNumber += "0"
            output.text = stringNumber
        }
        val one = findViewById<Button>(R.id.one)
        one.setOnClickListener {
            stringNumber += "1"
            output.text = stringNumber
        }
        val two = findViewById<Button>(R.id.two)
        two.setOnClickListener {
            stringNumber += "2"
            output.text = stringNumber
        }
        val three = findViewById<Button>(R.id.three)
        three.setOnClickListener {
            stringNumber += "3"
            output.text = stringNumber
        }
        val four = findViewById<Button>(R.id.four)
        four.setOnClickListener {
            stringNumber += "4"
            output.text = stringNumber
        }
        val five = findViewById<Button>(R.id.five)
        five.setOnClickListener {
            stringNumber += "5"
            output.text = stringNumber
        }
        val six = findViewById<Button>(R.id.six)
        six.setOnClickListener {
            stringNumber += "6"
            output.text = stringNumber
        }
        val seven = findViewById<Button>(R.id.seven)
        seven.setOnClickListener {
            stringNumber += "7"
            output.text = stringNumber
        }
        val eight = findViewById<Button>(R.id.eight)
        eight.setOnClickListener {
            stringNumber += "8"
            output.text = stringNumber
        }
        val nine = findViewById<Button>(R.id.nine)
        nine.setOnClickListener {
            stringNumber += "9"
            output.text = stringNumber
        }
        val dot = findViewById<Button>(R.id.dot)
        dot.setOnClickListener {
            stringNumber += "."
            output.text = stringNumber
        }
        val open = findViewById<Button>(R.id.openBracket)
        open.setOnClickListener {
            stringNumber += "("
            output.text = stringNumber
        }
        val close = findViewById<Button>(R.id.closeBracket)
        close.setOnClickListener {
            stringNumber += ")"
            output.text = stringNumber
        }

        val plus = findViewById<Button>(R.id.plus)
        plus.setOnClickListener {
            stringNumber += "+"
            output.text = stringNumber
        }
        val minus = findViewById<Button>(R.id.minus)
        minus.setOnClickListener {
            stringNumber += "-"
            output.text = stringNumber
        }
        val multiply = findViewById<Button>(R.id.multiply)
        multiply.setOnClickListener {
            stringNumber += "*"
            output.text = stringNumber
        }
        val divide = findViewById<Button>(R.id.divide)
        divide.setOnClickListener {
            stringNumber += "/"
            output.text = stringNumber
        }


        val equalto = findViewById<Button>(R.id.equalto)
        equalto.setOnClickListener {
            var expression = ExpressionBuilder(stringNumber).build()
            var result = expression.evaluate()
            var longResult = result.toLong()
            if (result == longResult.toDouble()) {
                screen.text = longResult.toString()
            } else {
                screen.text = result.toString()
            }
        }

        val ac: Button = findViewById(R.id.ac)
        ac.setOnClickListener {
            stringNumber = ""
            output.text = null
            screen.text = null
        }

    }

    fun lockPassword(view: View) {

        var password: String = ""

        var setting: SharedPreferences = getSharedPreferences("PRESS", 0)
        password = setting.getString("password", "").toString()
        // if there is no password set :
        if (password == "") {

            val lock: ImageButton = findViewById(R.id.lockbutton)
            lock.setOnClickListener {
                startActivity(Intent(this, CreatePassword::class.java))
            }
        }
        //if the password is already set :
        else {
            val lock: ImageButton = findViewById(R.id.lockbutton)
            lock.setOnClickListener {
                startActivity(Intent(this, EnterPassword::class.java))
            }

        }

    }
}