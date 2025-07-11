package pl.edu.pja.kdudek.filmoteka.data.db

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import pl.edu.pja.kdudek.filmoteka.data.datasource.SampleData
import javax.inject.Inject

class DatabasePopulationCallback @Inject constructor(
    private val sampleData: SampleData
) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        sampleData.exampleFilms.forEach {
            val values = ContentValues().apply {
                put("title", it.title)
                put("releaseDate", it.releaseDate.toEpochDay())
                put("category", it.category.name)
                put("isWatched", it.isWatched)
                put("rating", it.rating)
                put("comment", it.comment)
                put("posterUri", it.posterUri)
            }
            db.insert("films", SQLiteDatabase.CONFLICT_IGNORE, values)
        }
    }
}
