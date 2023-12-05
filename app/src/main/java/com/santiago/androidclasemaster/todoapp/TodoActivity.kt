package com.santiago.androidclasemaster.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.santiago.androidclasemaster.R

class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
    }

    private fun initUI() {

    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
    }
}