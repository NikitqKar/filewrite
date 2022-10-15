package com.nick.byfilemanagerandsteram

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.File

import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaring EditText, Buttons and TextViews from the layout file
        val mEditText = findViewById<EditText>(R.id.edit_text)
        val mButtonSave = findViewById<Button>(R.id.button1)
        val mTextView = findViewById<TextView>(R.id.text_view)

        // What happens when Save Button is pressed
        mButtonSave.setOnClickListener {
            if (mEditText.text.toString().isNotEmpty()) {

                // For First time: Creates a text file and writes string into it
                // Else: Opens the text file and writes the string
                try {
                    val data: String = "om namah shivaya"
                    val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

                    val folder = File(path, "urk")
                    folder.mkdirs()

                    println(folder.exists()) // u'll get true

                    val file = File(folder, "fff.txt")
                    file.appendText("$data")
                    Log.d("nick123","work")

                    Toast.makeText(baseContext, "File save on this adress $path!", Toast.LENGTH_LONG)
                        .show()
                    Log.d("nick123","Nework")

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                Toast.makeText(applicationContext, "No input?", Toast.LENGTH_SHORT).show()
            }
        }



}
    }
