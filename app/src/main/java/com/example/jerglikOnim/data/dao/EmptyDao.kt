package com.example.jerglikOnim.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.jerglikOnim.data.model.Product
import com.example.uy_bazarligi.Bazarliq

@Dao
interface EmptyDao {

@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

@Query("Select * from TableEmpty")
fun getAllProducts(): List<Bazarliq>
}