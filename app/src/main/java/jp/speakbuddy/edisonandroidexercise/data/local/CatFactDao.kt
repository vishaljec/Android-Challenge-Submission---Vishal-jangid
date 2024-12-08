package jp.speakbuddy.edisonandroidexercise.data.local

import CatFactEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CatFactDao {

    @Insert
    suspend fun insertCatFact(catFact: CatFactEntity)

    @Query("SELECT * FROM cat_fact LIMIT 1")
    suspend fun getCatFact(): CatFactEntity?
}