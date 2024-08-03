package com.example.domain.usecases.pets.impl

import com.example.domain.models.Result
import com.example.domain.models.pets.UpdatePet
import com.example.domain.repository_interfaces.PetRepository
import com.example.domain.usecases.pets.interfaces.UpdateNameStatusPetUseCase
import kotlinx.coroutines.flow.Flow

class UpdateNameStatusPetUseCaseImpl(private val repository: PetRepository) :
    UpdateNameStatusPetUseCase {
    override fun execute(pet: UpdatePet): Flow<Result> {
        return repository.updateNameAndStatusPet(pet = pet)
    }
}