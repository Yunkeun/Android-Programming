package kr.ac.dankook.mobile.mop1124_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timerText = findViewById<TextView>(R.id.timerText)
        val startBtn = findViewById<Button>(R.id.startBtn)
        val stopBtn = findViewById<Button>(R.id.stopBtn)
        var hourStr = ""
        var minuteStr = ""
        var started = false
        var stopped = false
        var restarted = false

        val myHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                Log.d("BkgThread", "Main thread")
                if (msg.what == 1) {
                    if (msg.arg1 < 10) {
                        hourStr = "0${msg.arg1}"
                    } else {
                        hourStr = msg.arg1.toString()
                    }
                    if (msg.arg2 < 10) {
                        minuteStr = "0${msg.arg2}"
                    } else {
                        minuteStr = msg.arg2.toString()
                    }
                    timerText.setText("${hourStr}:${minuteStr}")
                }
            }
        }
        Thread {
            var hour = 0
            var minute = 0

            while(true) {
                Thread.sleep(1000)
                Log.d("BkgThread", "In background thread hour: $hour minute: $minute")
                var msg = myHandler.obtainMessage()
                msg.what = 1
                if (stopped) {
                    continue
                }
                if (restarted) {
                    hour = 0
                    minute = -1
                    msg.arg1 = hour
                    msg.arg2 = minute
                    restarted = false
                }
                if (started) {
                    minute += 1
                    if (minute == 60) {
                        hour += 1
                        minute = 0
                    }
                    msg.arg1 = hour
                    msg.arg2 = minute
                } else {
                    hour = 0
                    minute = 0
                }
                myHandler.sendMessage(msg)
            }
        }.start()

        startBtn.setOnClickListener {
            Log.d("BkgThread", "Start button pressed")
            started = true
            stopped = false
            restarted = true
        }
        stopBtn.setOnClickListener {
            Log.d("BkgThread", "Stop button pressed")
            stopped = true
        }
    }
}