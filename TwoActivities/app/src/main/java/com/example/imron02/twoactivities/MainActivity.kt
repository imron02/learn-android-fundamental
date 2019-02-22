package com.example.imron02.twoactivities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val logtag = MainActivity::class.java.simpleName
    private lateinit var mMessageEditText: EditText
    private lateinit var mReplyHeadTextView: TextView
    private lateinit var mReplyTextView: TextView
    val TEXT_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
    }

    fun launchSecondActivity(view: View) {
        Log.d(logtag, "Button clicked!")
        val intent = Intent(this, SecondActivity::class.java)
        val message: String = mMessageEditText.text.toString()
        intent.putExtra("EXTRA_MESSAGE", message)

        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEXT_REQUEST && resultCode == Activity.RESULT_OK) {
            val reply: String = data!!.getStringExtra("EXTRA_REPLY")
            mReplyHeadTextView.visibility = View.VISIBLE
            mReplyHeadTextView.text = reply
            mReplyTextView.visibility = View.VISIBLE
            mMessageEditText.text = null
        }
    }
}
