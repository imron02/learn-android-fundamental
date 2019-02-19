package com.example.imron02.twoactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent



class MainActivity : AppCompatActivity() {
    private val logtag = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun launchSecondActivity(view: View) {
        Log.d(logtag, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
