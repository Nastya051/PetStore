package com.example.domain.usecases.pets.impl

import com.example.domain.models.Result
import com.example.domain.repository_interfaces.PetRepository
import com.example.domain.usecases.pets.interfaces.GetPetsByStatusUseCase
import kotlinx.coroutines.flow.Flow

class GetPetsByStatusUseCaseImpl(private val repository: PetRepository) : GetPetsByStatusUseCase {
    override fun execute(status: String): Flow<Result> {
        return repository.getPetsByStatus(status = status)
    }
}