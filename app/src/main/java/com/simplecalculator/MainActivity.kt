package com.simplecalculator

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var cal_button :Button
    lateinit var NumerEt1 : EditText
    lateinit var NumerEt2 : EditText
    lateinit var ResultEt : TextView
    lateinit var operations :AutoCompleteTextView
    var frist_number : Double = 0.0
    var second_number : Double = 0.0
    var Sum_number : Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Inilization()
        val listofitem = listOf("Plus","Minus","Multiply","Division")
        val adpater = ArrayAdapter(this,R.layout.list_item,listofitem)
        operations.setAdapter(adpater)
        cal_button.setOnClickListener {Calculation()}

    }
    private fun Inilization()
    {
        cal_button = findViewById(R.id.cal_button)
        NumerEt1 = findViewById(R.id.text1)
        NumerEt2 = findViewById(R.id.text2)
        ResultEt = findViewById(R.id.Result)
        operations = findViewById(R.id.operation)

    }
    private fun Calculation()
    {
        frist_number = NumerEt1.text.toString().toDouble()
        second_number = NumerEt2.text.toString().toDouble()
        val select_operation = operations.text.toString()
        Sum_number = when(select_operation) {
            "Plus" -> frist_number.plus(second_number)
            "Minus" -> frist_number.minus(second_number)
            "Multiply" -> frist_number.times(second_number)
            "Division" -> frist_number.div(second_number)
            else -> 0.0
        }
        ResultEt.setText(Sum_number.toString())


    }

}