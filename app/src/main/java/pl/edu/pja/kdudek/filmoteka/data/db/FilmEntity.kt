package pl.edu.pja.kdudek.filmoteka.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmCategory
import java.time.LocalDate

@Entity(tableName = "films")
data class FilmEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val releaseDate: LocalDate,
    val category: FilmCategory,
    val isWatched: Boolean,
    val rating: Int?,
    val comment: String?,
    val posterUri: String?
)
