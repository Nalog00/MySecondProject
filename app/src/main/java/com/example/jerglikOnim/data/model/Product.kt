package com.example.jerglikOnim.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TableEmpty")
data class Product (
    @ColumnInfo(name = "nameQq")
    var nameQq: String= "",

    @ColumnInfo(name = "olshemBirlik")
    var olshemBirlik: String= "",

    @ColumnInfo(name = "summa")
    var summa: String= "",

    @ColumnInfo(name =  "type")
    var type: Int = 0,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val  id: Int = 0
)