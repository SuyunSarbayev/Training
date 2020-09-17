package suyun.example.training.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import suyun.example.training.R
import suyun.example.training.splash.SplashFragment

class BaseActivity : AppCompatActivity() {

    var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(currentFragment == null){
            initiateDisplayFragment(SplashFragment())
        }
    }

    fun initiateDisplayFragment(fragment: Fragment){
        currentFragment?.let {
            supportFragmentManager.beginTransaction().hide(currentFragment!!)
        }

        currentFragment = fragment

        supportFragmentManager.beginTransaction()
            .add(R.id.framelayout_activity_main_container, currentFragment!!, currentFragment!!::class.java.name)
            .addToBackStack(currentFragment!!::class.java.name)
            .commit()
    }
}