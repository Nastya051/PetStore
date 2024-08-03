package com.example.domain.usecases.pets.interfaces

import com.example.domain.models.pets.PetInfo
import com.example.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface AddNewPetToStoreUseCase {
    fun execute(pet: PetInfo): Flow<Result>
}