package pl.edu.pja.kdudek.filmoteka.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pl.edu.pja.kdudek.filmoteka.data.datasource.SampleData
import pl.edu.pja.kdudek.filmoteka.data.db.AppDatabase
import pl.edu.pja.kdudek.filmoteka.data.db.DatabasePopulationCallback
import pl.edu.pja.kdudek.filmoteka.data.db.FilmDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideSampleData(): SampleData {
        return SampleData
    }

    @Provides
    @Singleton
    fun provideDatabasePopulationCallback(
        sampleData: SampleData
    ): DatabasePopulationCallback {
        return DatabasePopulationCallback(sampleData)
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext appContext: Context,
        databasePopulationCallback: DatabasePopulationCallback
    ): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "film_database"
        )
            .addCallback(databasePopulationCallback)
            .build()
    }

    @Provides
    @Singleton
    fun provideFilmDao(database: AppDatabase): FilmDao {
        return database.filmDao()
    }
}
