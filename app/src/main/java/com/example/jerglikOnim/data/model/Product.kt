package com.example.jerglikOnim.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TableEmpty")
data class Product (
    @ColumnInfo(name = "nameQq")
    val nameQq: String,

    @ColumnInfo(name = "olshemBirlik")
    val olshemBirlik: String,

    @ColumnInfo(name = "summa")
    val summa: String,

    @ColumnInfo(name =  "type")
    val type: Int = 0,

    @PrimaryKey(autoGenerate = true) val  id: Int = 0
)