package com.example.jerglikOnim.data.dao

import androidx.room.*
import com.example.jerglikOnim.data.model.Product

@Dao
interface EmptyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Query("Select * from TableEmpty")
    fun getAllProducts(): List<Product>

    @Update()
    fun updateDataInsert(product: Product)

    @Delete()
    fun deleteProduct(product: Product)

    @Query("Select * from TableEmpty where id=:id")
    fun getProductById(id: Int): Product
}
