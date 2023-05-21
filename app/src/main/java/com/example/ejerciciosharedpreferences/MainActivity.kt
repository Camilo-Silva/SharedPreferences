package com.example.ejerciciosharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var buttonToAction: Button
    private lateinit var textViewName: TextView
    private lateinit var editTextUserNameLogin: EditText
    private lateinit var editTextPasswordLogin: EditText
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToAction = findViewById(R.id.buttonLogin)
        textViewName = findViewById(R.id.textViewNombre)
        editTextUserNameLogin = findViewById(R.id.editTextNameLogin)
        editTextPasswordLogin = findViewById(R.id.editTextPasswordLogin)
        imageView = findViewById(R.id.imageView)

        //Construir las SharedPreferences
//        val preferences = getSharedPreferences()
        val preferences = getSharedPreferences("LoginPref", MODE_PRIVATE)
        val userNamePref = preferences.getString("name", "")
        val passwordPref = preferences.getString("pass", "")


        if (userNamePref != null && passwordPref != null) {
            if (userNamePref.isEmpty()) {
                buttonToAction.text = "registrar"
//                buttonToAction.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
//                }
            }
//            else {


//                buttonToAction.text = "continuar"

//                textViewName.text = userName

//                buttonToAction.setOnClickListener {
//                    val intent = Intent(this, FinalActivity::class.java)
//                    startActivity(intent)
//                }
//            }
        }

        buttonToAction.setOnClickListener {
            if (editTextUserNameLogin.text.isNullOrEmpty() && editTextPasswordLogin.text.isNullOrEmpty()) {
                Toast.makeText(this, "Ingrese user y password", Toast.LENGTH_SHORT).show()
            } else {
                val name = editTextUserNameLogin.text.toString()
                val pass = editTextPasswordLogin.text.toString()

                if (name == userNamePref && pass == passwordPref) {
//                    imageView.visibility = View.VISIBLE
//                    textViewName.text = name
//                    textViewName.visibility = View.VISIBLE
//                    buttonToAction.text = "continuar"
                    val intent = Intent(this, FinalActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "usuario o contraseña no valida", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}