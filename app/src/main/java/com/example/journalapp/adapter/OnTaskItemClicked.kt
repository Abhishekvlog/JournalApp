package com.example.journalapp.adapter

interface OnTaskItemClicked {



    fun onEditClicked(task: String)

    fun onDeleteClicked(task: String)
}