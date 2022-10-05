package com.example.textinputedittextdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val checkClicked = findViewById<TextInputLayout>(R.id.textinputLayoutCustom)
        val checkPhoneError = findViewById<TextInputEditText>(R.id.textinputEditTextPhone)
        val checkPhoneErrorLayout = findViewById<TextInputLayout>(R.id.textinputLayoutPhone)

        checkClicked.setEndIconOnClickListener{
            Toast.makeText(this,"Clicked", Toast.LENGTH_SHORT).show()
        }

        checkPhoneError.doOnTextChanged { text, start, before, count ->
            if (text!!.length > 11){

                checkPhoneErrorLayout.error = "No More!"

            }else if (text.length < 11){

                checkPhoneErrorLayout.error = null
            }
        }
    }
}