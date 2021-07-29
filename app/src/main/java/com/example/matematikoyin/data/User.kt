package com.example.matematikoyin.data

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Username")
data class User (
        @PrimaryKey(autoGenerate = true)
        val id : Int = 0,
        var username : String,
        var score : Int,
        )