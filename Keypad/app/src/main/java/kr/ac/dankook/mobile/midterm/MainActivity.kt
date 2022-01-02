package kr.ac.dankook.mobile.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newText = findViewById<TextView>(R.id.textView)
        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)
        val btn4 = findViewById<Button>(R.id.button4)
        val btn5 = findViewById<Button>(R.id.button5)
        val btn6 = findViewById<Button>(R.id.button6)
        val btn7 = findViewById<Button>(R.id.button7)
        val btn8 = findViewById<Button>(R.id.button8)
        val btn9 = findViewById<Button>(R.id.button9)
        val btn10 = findViewById<Button>(R.id.button10)
        val btn11 = findViewById<Button>(R.id.button11)
        val btn12 = findViewById<Button>(R.id.button12)
        var textSave = ""

        btn1.setOnClickListener {
            textSave += btn1.text
            newText.text = textSave
        }
        btn2.setOnClickListener {
            textSave += btn2.text
            newText.text = textSave
        }
        btn3.setOnClickListener {
            textSave += btn3.text
            newText.text = textSave
        }
        btn4.setOnClickListener {
            textSave += btn4.text
            newText.text = textSave
        }
        btn5.setOnClickListener {
            textSave += btn5.text
            newText.text = textSave
        }
        btn6.setOnClickListener {
            textSave += btn6.text
            newText.text = textSave
        }
        btn7.setOnClickListener {
            textSave += btn7.text
            newText.text = textSave
        }
        btn8.setOnClickListener {
            textSave += btn8.text
            newText.text = textSave
        }
        btn9.setOnClickListener {
            textSave += btn9.text
            newText.text = textSave
        }
        btn10.setOnClickListener {
            textSave += btn10.text
            newText.text = textSave
        }
        btn11.setOnClickListener {
            textSave += btn11.text
            newText.text = textSave
        }
        btn12.setOnClickListener {
            textSave += btn12.text
            newText.text = textSave
        }
    }
}