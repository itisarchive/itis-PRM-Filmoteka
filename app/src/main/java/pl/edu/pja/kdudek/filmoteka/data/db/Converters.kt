package pl.edu.pja.kdudek.filmoteka.data.db

import androidx.room.TypeConverter
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmCategory
import java.time.LocalDate

class Converters {

    @TypeConverter
    fun fromFilmCategory(category: FilmCategory): String = category.name

    @TypeConverter
    fun toFilmCategory(value: String): FilmCategory = FilmCategory.valueOf(value)

    @TypeConverter
    fun fromLocalDate(date: LocalDate?): Long? = date?.toEpochDay()

    @TypeConverter
    fun toLocalDate(epochDay: Long?): LocalDate? =
        epochDay?.let { LocalDate.ofEpochDay(it) }
}
