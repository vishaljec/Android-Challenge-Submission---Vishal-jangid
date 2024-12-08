package jp.speakbuddy.edisonandroidexercise.data.local

import CatFactEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CatFactEntity::class], version = 1, exportSchema = false)
abstract class CatFactDatabase : RoomDatabase() {
    abstract fun catFactDao(): CatFactDao
}