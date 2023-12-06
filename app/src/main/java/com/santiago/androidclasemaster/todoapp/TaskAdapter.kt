package com.santiago.androidclasemaster.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santiago.androidclasemaster.R

class TaskAdapter(private val task: List<Task>):
    RecyclerView.Adapter<TasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(view)
    }

       override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(task[position])
    }

    override fun getItemCount() = task.size
}