package com.example.ejerciciosharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var buttonContinueToLogin: Button
    private lateinit var editTextEnterName: EditText
    private lateinit var editTextEnterPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonContinueToLogin = findViewById(R.id.buttonToLogin)
        editTextEnterName = findViewById(R.id.editTextName)
        editTextEnterPassword = findViewById(R.id.editTextPassword)

        buttonContinueToLogin.setOnClickListener {
            if (editTextEnterName.text.isNullOrEmpty() && editTextEnterPassword.text.isNullOrEmpty()) {
                Toast.makeText(this, "Ingrese un nombre y password valido", Toast.LENGTH_SHORT).show()
            } else {
                val userName: String = editTextEnterName.text.toString()
                val password = editTextEnterPassword.text.toString()

                val preferences = getSharedPreferences("LoginPref", MODE_PRIVATE)
                //creamos variable para guardar la SharedPreferences y poder editarla
                val editor = preferences.edit()
                editor.putString("name", userName)
                editor.putString("pass", password)
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }

    }
}