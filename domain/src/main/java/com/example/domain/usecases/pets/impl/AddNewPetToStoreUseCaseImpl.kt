package com.example.domain.usecases.pets.impl

import com.example.domain.models.pets.PetInfo
import com.example.domain.models.Result
import com.example.domain.repository_interfaces.PetRepository
import com.example.domain.usecases.pets.interfaces.AddNewPetToStoreUseCase
import kotlinx.coroutines.flow.Flow

class AddNewPetToStoreUseCaseImpl(private val repository: PetRepository) : AddNewPetToStoreUseCase {
    override fun execute(pet: PetInfo): Flow<Result> {
        return repository.addNewPetToStore(pet = pet)
    }
}