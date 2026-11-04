package com.example.trailog.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trailog.R

class MainActivity : AppCompatActivity() {

    private val TAG = "Lifecycle"
    private var contador = 0
    private lateinit var tvContador: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d(TAG, "onCreate")

        tvContador = findViewById(R.id.tvContador)
        contador = savedInstanceState?.getInt("contador") ?: 0
        tvContador.text = contador.toString()

        findViewById<Button>(R.id.btnSumar).setOnClickListener {
            contador++
            tvContador.text = contador.toString()
        }
    }

    override fun onStart() { super.onStart(); Log.d(TAG, "onStart") }
    override fun onRestart() { super.onRestart(); Log.d(TAG, "onRestart") }
    override fun onResume() { super.onResume(); Log.d(TAG, "onResume") }
    override fun onPause() { super.onPause(); Log.d(TAG, "onPause") }
    override fun onStop() { super.onStop(); Log.d(TAG, "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contador)
        Log.d(TAG, "onSaveInstanceState: contador=$contador")
    }
}