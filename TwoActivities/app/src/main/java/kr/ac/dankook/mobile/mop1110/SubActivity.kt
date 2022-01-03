package kr.ac.dankook.mobile.mop1110

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val returnBtn = findViewById<Button>(R.id.returnBtn)
        returnBtn.setOnClickListener {
            finish()
        }
    }
}