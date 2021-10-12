package com.example.journalapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseHandler(val context: Context) :
    SQLiteOpenHelper(context,"journaldb",null,1) {

    companion object{
        val TABLE_NAME = "journal_table"
        val ID = "id"
        val TITLE = "title"
        val DESC = "desc"
        val DAY = "day"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val createQuery = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY," +
                " $TITLE TEXT, " +
                "$DESC TEXT, $DAY TEXT)"
        db?.execSQL(createQuery)
    }

    fun insertRoutine(title : String , desc : String , day : String){

        val db = writableDatabase

        val values = ContentValues()
        values.put(TITLE,title)
        values.put(DESC,desc)
        values.put(DAY,day)

        val id = db.insert(TABLE_NAME , null , values)

        if (id.toInt() == -1){
            Toast.makeText(context,"Error", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Successful", Toast.LENGTH_LONG).show()
        }
    }

    fun updateRoutine(id : Int , newTitle : String , newDesc : String , newDay : String){
        val db = writableDatabase
        val values = ContentValues()
       // values.put(ID, id)
        values.put(TITLE, newTitle)
        values.put(DESC , newDesc)
        values.put(DAY ,newDay)

       val affectRow = db.update(TABLE_NAME , values, "id = $id" , null)

        if (affectRow > 0){
            Toast.makeText(context,"Error", Toast.LENGTH_LONG).show()

        }
        else{
            Toast.makeText(context,"Successful", Toast.LENGTH_LONG).show()

        }
    }
    fun deleteRoutine(id: Int){
        val db = writableDatabase
        val delete = db.delete(TABLE_NAME,"id = $id",null)

        if(delete > 0){
            Toast.makeText(context,"Error in deletion", Toast.LENGTH_LONG).show()

        }
        else{
            Toast.makeText(context,"successful in delete", Toast.LENGTH_LONG).show()

        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}