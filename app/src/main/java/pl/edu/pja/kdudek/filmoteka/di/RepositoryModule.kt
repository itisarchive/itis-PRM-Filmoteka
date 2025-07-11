package pl.edu.pja.kdudek.filmoteka.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.edu.pja.kdudek.filmoteka.data.db.FilmDao
import pl.edu.pja.kdudek.filmoteka.data.mapper.FilmMapper
import pl.edu.pja.kdudek.filmoteka.data.repository.FilmRepository
import pl.edu.pja.kdudek.filmoteka.data.repository.FilmRepositoryImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFilmRepository(filmDao: FilmDao, mapper: FilmMapper): FilmRepository {
        return FilmRepositoryImpl(filmDao, mapper)
    }
}
