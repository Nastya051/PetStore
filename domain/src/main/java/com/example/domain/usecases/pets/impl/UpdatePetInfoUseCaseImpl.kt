package com.example.domain.usecases.pets.impl

import com.example.domain.models.pets.PetInfo
import com.example.domain.models.Result
import com.example.domain.repository_interfaces.PetRepository
import com.example.domain.usecases.pets.interfaces.UpdatePetInfoUseCase
import kotlinx.coroutines.flow.Flow

class UpdatePetInfoUseCaseImpl(private val repository: PetRepository) : UpdatePetInfoUseCase {
    override fun execute(pet: PetInfo): Flow<Result> {
        return repository.updatePet(pet = pet)
    }
}