package com.example.matematikoyin.data

import androidx.room.*
import com.example.matematikoyin.data.User

@Dao
interface MyDao {
    @Query("SELECT * FROM username")
    fun getAllUsername(): MutableList<User>

    @Query("SELECT * FROM username ORDER BY  score DESC")
    fun getPersonsSortByDescScore(): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)
}