package com.example.springStudent.springStudent.controller

import com.example.springStudent.springStudent.model.student
import com.example.springStudent.springStudent.repositories.StudentRepository
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
class StudentController {
    private lateinit var studentRepository: StudentRepository

    @Autowired
    fun setStudentRepository(studentRepo: StudentRepository) {
        studentRepository = studentRepo
    }

    @GetMapping("/student")
    fun getAllStudents() :ResponseEntity<ArrayList<student>> {
        val dataFromDatabase = studentRepository.findAll()
        val dataArrayList = ArrayList<student>()
        dataFromDatabase.forEach {
            dataArrayList.add(it)
        }
        return ResponseEntity.ok(dataArrayList)
    }

    @PostMapping("/student")
    fun insertStudent(@RequestBody data :String ){

        val gson = Gson()
        val newStudent = gson.fromJson(data , student::class.java)
        studentRepository.save(newStudent)

    }

    @PutMapping("/student/updating{name}")
    fun updateStudent(@PathVariable("name") name: String , @RequestBody data: String) {

        val gson = Gson()
        val newStudent: student = gson.fromJson(data, student::class.java)

        studentRepository.save(newStudent)

        System.out.println(name)

    }

    @DeleteMapping("/student/deleting{name}")
    fun deleteStudent(@PathVariable("name") name: String ) {
        studentRepository.deleteById(name)
    }

}