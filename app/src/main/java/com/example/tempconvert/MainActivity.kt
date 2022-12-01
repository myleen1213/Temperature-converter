package com.example.tempconvert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create edit text and buttons and connect them
        val fa = findViewById<EditText>(R.id.fa)
        val cels = findViewById<EditText>(R.id.cels)
        val cnvt_btn = findViewById<Button>(R.id.cnvt_btn)
        val reset_btn = findViewById<Button>(R.id.reset_btn)
        val c2fSum = findViewById<TextView>(R.id.fa)//ithink
        val f2cSum = findViewById<TextView>(R.id.cels)//ithink


        //When user clicks convert button this function will run

        cnvt_btn.setOnClickListener {

            //if c2f has entry and f2c is empty calculate c2f
            if (cels.length() > 0 && fa.length() == 0) {
                try {
                    val cel = cels.text.toString().toFloat()
                    val c2f = (cel * 9 / 5) + 32
                    c2fSum.text = c2f.toString()
                } catch (e: NumberFormatException) {
                    Toast.makeText(
                        applicationContext,
                        "Please enter valid temperature, Numbers only ",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.i("Myleen", "Unable to convert temperature")

                }

                //else if fa has entry and cels is empty calculate fa

            } else if (fa.length() > 0 && cels.length() == 0) {


                try {
                    val f = fa.text.toString().toFloat()
                    val f2c = (f - 32) * 5 / 9
                    f2cSum.text = f2c.toString()
                } catch (e: NumberFormatException) {
                    Toast.makeText(
                        applicationContext,
                        "Please enter valid temperature",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.i("Myleen", "Unable to convert temperature")

                }
            }
        }

        reset_btn.setOnClickListener {
            cels.setText("")
            f2cSum.setText("")
            fa.setText("")
            c2fSum.setText("")
        }
    }

    private fun exit0() {
        println("Please enter a value")
    }
}

