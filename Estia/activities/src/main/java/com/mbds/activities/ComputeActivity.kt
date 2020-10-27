package com.mbds.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class ComputeActiviy : AppCompatActivity(),TextWatcher {
    private lateinit var calculerButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var number1TextEdit: EditText
    private lateinit var number2TextEdit: EditText
    private var calculResult = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        calculerButton = findViewById(R.id.btn_calculer)
        resultTextView = findViewById(R.id.resultat)
        number1TextEdit = findViewById(R.id.field_1)
        number2TextEdit = findViewById(R.id.field_2)

        number1TextEdit.addTextChangedListener(this)
        number2TextEdit.addTextChangedListener(this)

        calculerButton.setOnClickListener {
            calculResult = number1TextEdit.text.toString().toInt() + number2TextEdit.text.toString().toInt()
            val newText = "Le résultat de l'addition est: $calculResult"
            resultTextView.text = newText
        }

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        calculerButton.isEnabled = number1TextEdit.text.isNotEmpty() && number2TextEdit.text.isNotEmpty()
        if (!calculerButton.isEnabled){
            resultTextView.text =""
        }
    }

    override fun afterTextChanged(s: Editable?) {

    }


}