package com.santiago.androidclasemaster.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.santiago.androidclasemaster.R

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other
    )
    private val tasks = mutableListOf(
        Task("PruebaBusiness", TaskCategory.Business),
       Task("PruebaPersonal", TaskCategory.Personal),
         Task("PruebaOther", TaskCategory.Other)
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var fabAddTask: FloatingActionButton
    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog(){
        val dialog = Dialog(this)

       dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if(currentTask.isNotEmpty()){

                val selectedId = rgCategories.checkedRadioButtonId //me devuelve el id del radiogroup seleccionado ojo solo el id
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId) //aca tengo el radio seleccionado
                val currentCategory:TaskCategory = when(selectedRadioButton.text){
                    getString(R.string.todo_dialog_category_business) -> TaskCategory.Business
                    getString(R.string.todo_dialog_category_personal) -> TaskCategory.Personal
                    else -> TaskCategory.Other
                }

                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()


            }


        }
        dialog.show()

    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        //aca coloco el recyclerView horizontal o vertical
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun updateTasks(){
       // val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
      //  val newTasks = tasks.filter { selectedCategories.contains(it.category) }


        taskAdapter.notifyDataSetChanged()
    }
    private fun onItemSelected(position:Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }
}