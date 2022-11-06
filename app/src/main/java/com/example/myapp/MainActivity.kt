package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumber = findViewById<EditText>(R.id.edt_one)
        val secondNumber = findViewById<EditText>(R.id.edt_two)

        val btnPlus = findViewById<Button>(R.id.btn_plus)
        val btnMinus = findViewById<Button>(R.id.btn_minus)
        val btnMul = findViewById<Button>(R.id.btn_multiple)
        val btnDiv = findViewById<Button>(R.id.btn_div)

        btnPlus.setOnClickListener {
             validate(firstNumber.text.toString(), secondNumber.text.toString(), '+')
        }
        btnMinus.setOnClickListener {
            validate(firstNumber.text.toString(), secondNumber.text.toString(), '-')
        }
        btnMul.setOnClickListener {
            validate(firstNumber.text.toString(), secondNumber.text.toString(), '*')
        }
        btnDiv.setOnClickListener {
            validate(firstNumber.text.toString(), secondNumber.text.toString(), '/')
        }
    }
    private fun validate(first:String, second:String, operator:Char){
        val firstNumber = findViewById<EditText>(R.id.edt_one)
        val secondNumber = findViewById<EditText>(R.id.edt_two)
        val resultSection = findViewById<TextView>(R.id.tv_result)

        if (first.isEmpty()){
            resultSection.text = "Add a Number!"
        }
        if (second.isEmpty()){
            resultSection.text = "Add second number"
        }
        if (first.isNotEmpty() && second.isNotEmpty()){
            calculation(first.toDouble(), second.toDouble(), operator)
        }
    }

    private fun calculation(awal:Double, kedua:Double, operator:Char){
        var result =0.0
        when(operator){
            '+' -> result = awal + kedua
            '-' -> result = awal - kedua
            '*' -> result = awal * kedua
            '/' -> result = awal / kedua
        }

        val resultSection = findViewById<TextView>(R.id.tv_result)
        resultSection.text = result.toString()
    }
}


