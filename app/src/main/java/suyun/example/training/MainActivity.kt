package suyun.example.training

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager  = supportFragmentManager

        fragmentManager.beginTransaction()
            .add(R.id.framelayout_activity_main_container, MainFragment(), "MainFragment")
            .commit()
    }
}