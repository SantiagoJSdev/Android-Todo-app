package com.santiago.androidclasemaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.santiago.androidclasemaster.todoapp.TodoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTODO = findViewById<Button>(R.id.btnTODO)
        btnTODO.setOnClickListener { navigateToTodoApp() }
    }

    private fun navigateToTodoApp() {
       val intent = Intent(this, TodoActivity::class.java)
       startActivity(intent)
    }
}