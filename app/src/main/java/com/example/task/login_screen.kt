package com.example.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class login_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        var edemail = findViewById<EditText>(R.id.login_em)
        var edpass = findViewById<EditText>(R.id.pass_log)
        var logbtn = findViewById<Button>(R.id.btn1_log)

        logbtn.setOnClickListener {
            var exist = true
            var emailT = edemail.text.toString()
            var passT = edpass.text.toString()

            for ( p in Data.users) {
                if (p.email == emailT && p.pass == passT) {
                    Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()

//                    exist = false
                    Data.logeduser.name = p.name
                    Data.logeduser.email = p.email
                    Data.logeduser.pass = p.pass
                    Data.logeduser.country = p.country
                    Data.logeduser.phone = p.phone

                    var i = Intent(this, Home::class.java)
                    startActivity(i)
                    break
                }

            }
            if (exist == true) {
                Toast.makeText(this, " Not Found This User", Toast.LENGTH_SHORT).show()

            }
        }
        var btn_gosignup = findViewById<TextView>(R.id.gosginup)
        btn_gosignup.setOnClickListener {

            var i = Intent(this, sign_upscreen::class.java)
            startActivity(i)
        }


    }
}