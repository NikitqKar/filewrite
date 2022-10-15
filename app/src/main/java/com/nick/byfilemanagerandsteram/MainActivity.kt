package com.nick.byfilemanagerandsteram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.nick.byfilemanagerandsteram.databinding.ActivityMainBinding
import java.io.File
import java.lang.Exception

private val binding: ActivityMainBinding? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mEditText: String = binding.editText.toString()
        val mButtonSave = binding.button1

        mButtonSave.setOnClickListener {
            if (mEditText.isNotEmpty()) {
                try {
                    val data = "putin huy"
                    val path =
                        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

                    val folder = File(path, "fwe")
                    folder.mkdirs()

                    val file = File(folder, "fff.txt")
                    file.appendText(data)

                    Toast.makeText(
                        baseContext,
                        "File save on this adress $path!",
                        Toast.LENGTH_LONG
                    )
                        .show()

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                Toast.makeText(applicationContext, "No input?", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
