package com.example.imron02.twoactivities

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.content.Intent



class SecondActivity : AppCompatActivity() {
    private lateinit var mReply: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent
        val message: String = intent.getStringExtra("EXTRA_MESSAGE")
        val textView: TextView? = findViewById(R.id.text_message)
        textView!!.text = message

        mReply = findViewById(R.id.editText_second)
    }

    fun returnReply(view: View) {
        val reply: String = mReply.text.toString()
        val replyIntent = Intent()

        replyIntent.putExtra("EXTRA_REPLY", reply)
        setResult(Activity.RESULT_OK, replyIntent)

        finish()
    }
}
