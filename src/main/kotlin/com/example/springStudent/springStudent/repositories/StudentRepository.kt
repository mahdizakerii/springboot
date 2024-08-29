package com.example.springStudent.springStudent.repositories

import com.example.springStudent.springStudent.model.student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository :CrudRepository<student , String>