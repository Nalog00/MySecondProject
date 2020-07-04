package com.example.jerglikOnim.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jerglikOnim.data.dao.EmptyDao
import com.example.jerglikOnim.data.model.Product

@Database(entities = [Product::class], version = 1)
abstract class EmptyDatabase: RoomDatabase(){
    companion object{
        private lateinit var INSTANCE: EmptyDatabase

        fun getInstance(context: Context): EmptyDatabase {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context,EmptyDatabase::class.java, "empty.db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
    abstract fun dao(): EmptyDao
}