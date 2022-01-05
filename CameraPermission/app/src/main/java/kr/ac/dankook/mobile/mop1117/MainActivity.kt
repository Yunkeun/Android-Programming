package kr.ac.dankook.mobile.mop1117

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var camBtn = findViewById<Button>(R.id.camBtn)
        camBtn.setOnClickListener {
            Log.d("DKM", "CAMERA Button pressed")
            var camPermit = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
            if (camPermit == PackageManager.PERMISSION_GRANTED) {
                Log.d("DKM", "Camera permission already granted")
                var permitTxt = findViewById<TextView>(R.id.permitTxt)
                permitTxt.text = "Camera permission already granted"
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 99)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var permitTxt = findViewById<TextView>(R.id.permitTxt)

        when(requestCode) {
            99 -> {
                Log.d("DKM", "grantResult[0]="+grantResults[0].toString())
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("DKM", "Allow: CAMERA permission granted now")
                    permitTxt.text = "Allow: CAMERA permission granted now"
                } else {
                    Log.d("DKM", "Deny: CAMERA permission not granted")
                    permitTxt.text = "Deny: CAMERA permission not granted"
                }
            }
        }
    }
}