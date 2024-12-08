package jp.speakbuddy.edisonandroidexercise.data.local

import CatFactEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CatFactDao {
    @Query("SELECT * FROM cat_fact LIMIT 1")
    suspend fun getLatestCatFact(): CatFactEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCatFact(catFact: CatFactEntity)
}