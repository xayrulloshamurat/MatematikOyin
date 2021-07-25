package com.example.matematikoyin.data

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Username")
data class User (
        @PrimaryKey
        val id : Int,
        val username : String,
        )