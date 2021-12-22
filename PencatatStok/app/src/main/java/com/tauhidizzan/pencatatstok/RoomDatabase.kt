package com.tauhidizzan.pencatatstok

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class RoomDatabases {
    @Database(entities = [StokBarang::class], version = 1)
    abstract class AppDatabase: RoomDatabase() {
        abstract fun myFriendDao(): StokBarangDao
        companion object {
            var INSTANCE: AppDatabase? = null
            fun getAppDataBase(context: Context): AppDatabase? {
                if (INSTANCE == null){
                    synchronized(AppDatabase::class){
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "MyFriendAppDB").build()
                    }
                }
                return INSTANCE
            }
            fun destroyDataBase(){
                INSTANCE = null
            }
        }
    }
}