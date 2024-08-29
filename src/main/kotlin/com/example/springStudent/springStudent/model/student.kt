package com.example.springStudent.springStudent.model

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class student (

    @Id
    val name :String ,

    val course :String ,
    val score :Int

)
{
    constructor() :this("" , "" , -1)
}