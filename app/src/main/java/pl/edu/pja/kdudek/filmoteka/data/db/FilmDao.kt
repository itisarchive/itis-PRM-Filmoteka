package pl.edu.pja.kdudek.filmoteka.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDao {

    @Query("SELECT COUNT(*) FROM films")
    suspend fun getFilmsCount(): Int

    @Query("SELECT * FROM films ORDER BY releaseDate ASC")
    fun getAllFilms(): Flow<List<FilmEntity>>

    @Query("SELECT * FROM films WHERE id = :id")
    fun getFilmById(id: Long): Flow<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: FilmEntity): Long

    @Update
    suspend fun updateFilm(film: FilmEntity)

    @Delete
    suspend fun deleteFilm(film: FilmEntity)
}
