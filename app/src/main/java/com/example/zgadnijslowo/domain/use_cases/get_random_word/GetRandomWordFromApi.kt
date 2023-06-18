package com.example.zgadnijslowo.domain.use_cases.get_random_word

import com.example.zgadnijslowo.data.repository.Repository
import com.example.zgadnijslowo.domain.model.Word
import kotlinx.coroutines.flow.Flow

class GetRandomWordFromApi(
    private val repository: Repository,
) {
    suspend operator fun invoke(letters: String): Flow<Word> {
        return repository.getRandomWordFromAPI(letters = letters)
    }
}