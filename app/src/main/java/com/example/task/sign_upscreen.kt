package com.example.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class sign_upscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_upscreen)
        var data = Data()
        var edName = findViewById<EditText>(R.id.nameup)
        var edemail = findViewById<EditText>(R.id.signupmail)
        var edpassword = findViewById<EditText>(R.id.password_up)
        var country = findViewById<EditText>(R.id.country)
        var phone = findViewById<EditText>(R.id.phone)
        var go_login = findViewById<Button>(R.id.btn_goup)


        go_login.setOnClickListener {
            var edNameT = edName.text.toString()
            var edemail = edemail.text.toString()
            var edpass = edpassword.text.toString()
            var edcountry = country.text.toString()
            var edphone = phone.text.toString()
            var u = User(edNameT, edemail, edpass, edcountry, edphone)
            Data.users.add(u)

            if (edNameT==""||edemail==""||edpass==""||edcountry==""||edphone==""){
                Toast.makeText(this, "this feild is empty", Toast.LENGTH_SHORT).show()

            }else{
                    var i = Intent(this, login_screen::class.java)
                    startActivity(i)
                    finish()
            }


        }


    }
}