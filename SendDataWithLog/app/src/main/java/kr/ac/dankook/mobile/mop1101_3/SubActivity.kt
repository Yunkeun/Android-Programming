package kr.ac.dankook.mobile.mop1101_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val intentSub = intent

        val num1R = intentSub.getIntExtra("num1Extra", 0)
        val num2R = intentSub.getIntExtra("num2Extra", 0)

        Log.d("DKUMOB", "SubActivity onCreate()")
        Log.d("DKUMOB", "getExtra: "+num1R.toString()+", "+num2R.toString())

        val resultTxt = findViewById<TextView>(R.id.resultText)
        resultTxt.text = num1R.toString()+"+"+num2R.toString()+"="+((num1R+num2R).toString())

        val returnBtn = findViewById<Button>(R.id.returnBtn)
        returnBtn.setOnClickListener {
            Log.d("DKUMOB", "Return!")
            val outIntent = Intent(this, MainActivity::class.java)
            outIntent.putExtra("result", num1R+num2R)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("DKUMOB", "SubActivity onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("DKUMOB", "SubActivity onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("DKUMOB", "SubActivity onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("DKUMOB", "SubActivity onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("DKUMOB", "SubActivity onDestroy()")
    }
}