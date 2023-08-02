package com.example.studentregister.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room

// this should be abstract class
// this should extend RoomDatabase
@Database(entities = [Student::class],version=1,exportSchema=false)
abstract class StudentDatabase:RoomDatabase() {
    //We need to define an abstract function which returns an instance of studentDao  interface it should have any argu
    abstract fun studentDao():StudentDao
    //next we need to write codes to create an  instance of the database
    companion object{
        // define instance with volatile anotaion
        @Volatile
        private var INSTANCE : StudentDatabase? = null
        fun getInstance(context: Context):StudentDatabase{
            synchronized(this){
                var instance  = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDatabase::class.java,
                        "student_data_database"
                    ).build()
                }
                return instance
            }
        }
    }
}
// Thats it this is the database class which provides database instance