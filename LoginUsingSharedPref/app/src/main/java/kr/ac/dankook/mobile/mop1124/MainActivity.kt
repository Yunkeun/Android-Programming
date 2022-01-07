package kr.ac.dankook.mobile.mop1124

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MOBPRGRM", "Main activity")

        val sharedPref = getSharedPreferences("kr.ac.dankook.example.SHARED_PREF", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val username:String? = sharedPref.getString("username", "unknown")
        val password:String? = sharedPref.getString("password", "****")
        val id = sharedPref.getInt("id", -1)

        var usernameTxt = findViewById<TextView>(R.id.editTextUsername)
        var passwordTxt = findViewById<EditText>(R.id.editTextPassword)
        var loginBtn = findViewById<Button>(R.id.loginBtn)

        if (id == -1) {
            Log.d("MOBPRGRM", "There is no saved one")
            loginBtn.setOnClickListener {
                Log.d("MOBPRGRM", "Click the login button")
                if (usernameTxt != null && passwordTxt != null) {
                    editor.putString("username", usernameTxt.text.toString())
                    Log.d("MOBPRGRM", "username: ${usernameTxt.text}")
                    editor.putString("password", passwordTxt.text.toString())
                    Log.d("MOBPRGRM", "password: ${passwordTxt.text}")
                    editor.putInt("id", 1)
                    editor.apply()
                }
            }
        } else {
            Log.d("MOBPRGRM", "There is a saved one: username:$username, password:$password")

            usernameTxt.text = username
        }
    }
}