package com.gic.hlgame

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    var randomn = 0
    var count = 0
    var t: TextView? = null
    fun GenRanNo() {
        val rand = Random()
        randomn = rand.nextInt(20) + 1
    }

    @SuppressLint("WrongConstant")
    fun guess(view: View?) {
        count++
        val ug = findViewById<View>(R.id.et) as EditText
        val gn = ug.text.toString().toInt()
        val bgc = findViewById<View>(R.id.bg) as ImageView
        val t = findViewById<View>(R.id.textView) as TextView
        val g = findViewById<View>(R.id.textView2) as TextView
        when {
            gn > randomn -> {
                t.visibility = View.INVISIBLE
                g.visibility = View.INVISIBLE
                bgc.setImageResource(R.drawable.lower)
                Toast.makeText(this, "GO LOWERRR!", Toast.LENGTH_LONG).show()
            }
            gn < randomn -> {
                t.visibility = View.INVISIBLE
                g.visibility = View.INVISIBLE
                bgc.setImageResource(R.drawable.higher)
                Toast.makeText(this, "GO HIGHEERR!", Toast.LENGTH_LONG).show()
            }
            else -> {
                bgc.setImageResource(R.drawable.patrick)
                t.visibility = View.INVISIBLE
                g.visibility = View.INVISIBLE
                ug.visibility = View.INVISIBLE
                Toast.makeText(this, "Wow! It took you $count tries!", Toast.LENGTH_LONG).show()
                GenRanNo()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GenRanNo()
        t = findViewById<View>(R.id.check) as TextView
    }
}