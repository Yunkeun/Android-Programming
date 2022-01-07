package kr.ac.dankook.mobile.mop1124_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            UserDB::class.java, "userdb"
        ).allowMainThreadQueries().build()

        val users = db.userDao().getAll()

        if (users.isNotEmpty()) {
            Log.d("USERDB", "Something in db")
            var readUser = db.userDao().findByName("Yunkeun", "Cho")
            if (readUser != null) {
                Log.d("USERDB", readUser.firstName+" "+readUser.lastName)
            } else {
                Log.d("USERDB", "readUser is empty")
            }
        } else {
            Log.d("USERDB", "Nothing in db")
            val userd = User(1, "Yunkeun", "Cho")
            db.userDao().insertAll(userd)
            Log.d("USERDB", "$userd inserts!")
        }
    }
}