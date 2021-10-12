package com.example.journalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.journalapp.adapter.OnTaskItemClicked
import com.example.journalapp.adapter.RoutineAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), OnTaskItemClicked {

    private val routineList: MutableList<String> = mutableListOf()
    lateinit var mAdapter: RoutineAdapter
    lateinit var dbHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        routineList.add("hello")
        routineList.add("hello")
        routineList.add("hello")
        routineList.add("hello")

        mAdapter = RoutineAdapter(this, routineList, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = mAdapter
        dbHandler = DatabaseHandler(this)

        addBtn.setOnClickListener{
            dbHandler.insertRoutine("Drinkwater" , "Healthy to mind ", "Tue")
        }
        delete.setOnClickListener{
            dbHandler.deleteRoutine(1)
        }
        update.setOnClickListener{
            dbHandler.updateRoutine(1,"Drink Mile" , "For stronger bones" , "Mon")
        }


    }

    override fun onEditClicked(task: String) {

    }

    override fun onDeleteClicked(task: String) {

    }
}