package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_plus.setOnClickListener{

        validate(edt_one.text.toString(), edt_two.text.toString(), operator: '+')

        }
        btn_mius.setOnClickListener{
            validate(edt_one.text.toString(), edt_two.text.toString(), operator:'-')

        }
        btn_multiple.setOnClickListener{
            validate(edt_one.text.toString(), edt_two.text.toString(), operator: '*')



        }

        btn_div.setOnClickListener{
            validate(edt_one.text.toString(), edt_two.text.toString(), operator: '/')

        }

        private fun validate(awal:String, kedua:String, operator:Char){
            if (awal.isEmpty()){
                edt_one.error="Add a Number!"

            }
            if (kedua.isEmpty()){
                edt_two.error ="Add a Number!"
            }
            if (awal.isEmpty() && kedua.isNotEmpty()){
                calculation(awal.toDouble(), kedua.toDouble(), operator)
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
            val tv_resut = null
            tv_resut.text = result.toString()
        }
    }
}


