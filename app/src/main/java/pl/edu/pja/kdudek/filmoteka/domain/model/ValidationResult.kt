package pl.edu.pja.kdudek.filmoteka.domain.model

data class ValidationResult(
    val isSuccessful: Boolean,
    val errorMessages: List<ValidationError> = emptyList()
)
