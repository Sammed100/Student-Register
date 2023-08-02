package com.example.studentregister

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.studentregister.db.Student

//This class should extend recyclerViewAdapter class
// But in order to that we need a viewHolder class  for viewItem xml layout we just created
// type of adapter is the viewHolder class u created
// then create members of this Adapter function
class StudentRecyclerViewAdapter(
    private val clickListener:(Student)->Unit
):RecyclerView.Adapter<StudentViewHolder>() {

    private val studentList = ArrayList<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        //first get instance of layout inflater
        val layoutInflater = LayoutInflater.from(parent.context)
        // now we will inflate the listItem view
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        // now we will use StudentViewHolder class and listItems as its parameter and return it
        return StudentViewHolder(listItem)
    }
    // This OnBindViewHolder recieves StudentViewHolder as a parameter which we just created above
    // the fwork of this function is to get the getting the relevant object from list and pass it to the viewHolder
    // but for that we need to have a ListOfStudents and Setter function for it.
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position],clickListener)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun setList(students:List<Student>){
        studentList.clear()
        studentList.addAll(students)
    }

}
// create a viewHolder class and this should extend recycleview Holder class
class StudentViewHolder(private val view: View):RecyclerView.ViewHolder(view){
    // Now u will use a function to bind items to listItem Layout
    fun bind(student : Student,clickListener:(Student)->Unit){
        val nameTextView = view.findViewById<TextView>(R.id.tvName)
        val emailTextView = view.findViewById<TextView>(R.id.tvEmail)
        nameTextView.text = student.name
        emailTextView.text = student.email
        // view here represent a list item
        view.setOnClickListener{
            clickListener(student)
        }
    }
}