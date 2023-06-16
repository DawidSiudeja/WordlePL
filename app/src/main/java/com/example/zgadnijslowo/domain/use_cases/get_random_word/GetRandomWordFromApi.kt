package com.example.zgadnijslowo.domain.use_cases.get_random_word

import com.example.zgadnijslowo.data.repository.Repository

class GetRandomWordFromApi(
    private val repository: Repository
) {
    suspend operator fun invoke() {
        return repository.getAllWords()
    }
}