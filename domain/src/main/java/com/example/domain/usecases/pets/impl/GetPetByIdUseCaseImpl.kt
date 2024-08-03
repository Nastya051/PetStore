package com.example.domain.usecases.pets.impl

import com.example.domain.models.Result
import com.example.domain.repository_interfaces.PetRepository
import com.example.domain.usecases.pets.interfaces.GetPetByIdUseCase
import kotlinx.coroutines.flow.Flow

class GetPetByIdUseCaseImpl(private val repository: PetRepository) : GetPetByIdUseCase {
    override fun execute(id: Long): Flow<Result> {
        return repository.getPetById(id = id)
    }
}