package com.santiago.androidclasemaster.todoapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.santiago.androidclasemaster.R

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvCategoryName:TextView = view.findViewById(R.id.tvCategoryName)
    private val divider:View = view.findViewById(R.id.divider)
    fun render(taskCategory: TaskCategory) {


        when(taskCategory){
            TaskCategory.Business -> {
                tvCategoryName.text = "Negocios"
            }
            TaskCategory.Other -> {
                tvCategoryName.text = "Otros"
            }
            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal"
            }
        }
    }
}