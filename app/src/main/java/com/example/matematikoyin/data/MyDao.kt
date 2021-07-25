package com.example.matematikoyin.data

import androidx.room.Dao
import androidx.room.Query
import com.example.matematikoyin.data.User

@Dao
interface MyDao {
    @Query("SELECT * FROM username")
    fun getAllUsername() : MutableList<User>
}