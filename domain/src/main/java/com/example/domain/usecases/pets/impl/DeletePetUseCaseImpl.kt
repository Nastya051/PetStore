package com.example.domain.usecases.pets.impl

import com.example.domain.models.Result
import com.example.domain.repository_interfaces.PetRepository
import com.example.domain.usecases.pets.interfaces.DeletePetUseCase
import kotlinx.coroutines.flow.Flow

class DeletePetUseCaseImpl(private val repository: PetRepository) : DeletePetUseCase {
    override fun execute(id: Long): Flow<Result> {
        return repository.deletePet(id = id)
    }
}