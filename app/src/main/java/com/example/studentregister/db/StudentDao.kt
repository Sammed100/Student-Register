package com.example.studentregister.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query
import androidx.room.*

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    // write a query function to get all saved data as live data with return type as LiveDATA
    @Query("SELECT * fROM student_data_table")
    fun getAllStudents():LiveData<List<Student>>
}