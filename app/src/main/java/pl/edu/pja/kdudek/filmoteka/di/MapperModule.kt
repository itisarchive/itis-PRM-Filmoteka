package pl.edu.pja.kdudek.filmoteka.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.edu.pja.kdudek.filmoteka.data.mapper.FilmMapper
import pl.edu.pja.kdudek.filmoteka.data.mapper.FilmMapperImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    @Singleton
    fun filmMapper(): FilmMapper = FilmMapperImpl()
}
