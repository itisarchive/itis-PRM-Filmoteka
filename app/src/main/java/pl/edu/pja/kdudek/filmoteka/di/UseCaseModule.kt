package pl.edu.pja.kdudek.filmoteka.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.edu.pja.kdudek.filmoteka.data.repository.FilmRepository
import pl.edu.pja.kdudek.filmoteka.domain.usecase.DeleteFilmUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.GetAllFilmsUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.GetFilmByIdUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.GetFilteredFilmsUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.InsertFilmUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.UpdateFilmUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.ValidateFilmUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideDeleteFilmUseCase(repository: FilmRepository): DeleteFilmUseCase {
        return DeleteFilmUseCase(
            repository = repository
        )
    }

    @Provides
    fun provideGetAllFilmsUseCase(repository: FilmRepository): GetAllFilmsUseCase {
        return GetAllFilmsUseCase(
            repository = repository
        )
    }

    @Provides
    fun provideGetFilmByIdUseCase(repository: FilmRepository): GetFilmByIdUseCase {
        return GetFilmByIdUseCase(
            repository = repository
        )
    }

    @Provides
    fun provideGetFilteredFilmsUseCase(repository: FilmRepository): GetFilteredFilmsUseCase {
        return GetFilteredFilmsUseCase(
            repository = repository
        )
    }

    @Provides
    fun provideInsertFilmUseCase(repository: FilmRepository): InsertFilmUseCase {
        return InsertFilmUseCase(
            repository = repository
        )
    }

    @Provides
    fun provideUpdateFilmUseCase(repository: FilmRepository): UpdateFilmUseCase {
        return UpdateFilmUseCase(
            repository = repository
        )
    }

    @Provides
    fun provideValidateFilmUseCase(): ValidateFilmUseCase {
        return ValidateFilmUseCase()
    }
}
