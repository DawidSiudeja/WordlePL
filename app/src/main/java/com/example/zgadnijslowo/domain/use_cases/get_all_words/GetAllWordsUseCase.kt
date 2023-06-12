import com.example.zgadnijslowo.data.repository.Repository

class GetAllWordsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() {
        return repository.getAllWords()
    }
}