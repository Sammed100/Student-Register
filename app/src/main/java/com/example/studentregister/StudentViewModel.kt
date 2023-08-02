package com.example.studentregister

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentregister.db.Student
import com.example.studentregister.db.StudentDao
import kotlinx.coroutines.launch

// This Class should extend original viewModel
// we should provide dao interface as the constructor parameter datatype is student dao
class StudentViewModel(private val dao:StudentDao): ViewModel() {
    //we have written four chrome database functions StudentDao we need to connect with them all from this viewmodel class
    // now define a val to get the student data as live data
    val students = dao.getAllStudents()
    // to get the list of students all we need to do is serving this ViewModel from mainActivity

    // now we have to save the list of students
    fun insertStudent(student:Student)= viewModelScope.launch {
        dao.insertStudent(student)
    }

    fun updateStudent(student:Student)= viewModelScope.launch {
        dao.updateStudent(student)
    }

    fun deleteStudent(student:Student)= viewModelScope.launch {
        dao.deleteStudent(student)
    }
}
//when our view model has a constructor parameter like this we need  to create a view model factory class for that and provide it to the viewmodel provider