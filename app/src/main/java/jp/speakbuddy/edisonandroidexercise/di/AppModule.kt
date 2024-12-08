package jp.speakbuddy.edisonandroidexercise.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.speakbuddy.edisonandroidexercise.data.api.CatFactApi
import jp.speakbuddy.edisonandroidexercise.data.local.CatFactDao
import jp.speakbuddy.edisonandroidexercise.data.local.CatFactDatabase
import jp.speakbuddy.edisonandroidexercise.data.repo.CatFactRepositoryImpl
import jp.speakbuddy.edisonandroidexercise.domain.repo.CatFactRepository
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CatFactDatabase {
        return Room.databaseBuilder(context, CatFactDatabase::class.java, "cat_fact_db").build()
    }

    @Provides
    fun provideCatFactDao(database: CatFactDatabase): CatFactDao {
        return database.catFactDao()
    }

    @Provides
    fun provideRepository(dao: CatFactDao): CatFactRepository {
        return CatFactRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCatFactApi(retrofit: Retrofit): CatFactApi {
        return retrofit.create(CatFactApi::class.java)
    }
}