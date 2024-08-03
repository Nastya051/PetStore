package com.example.domain.usecases.pets.interfaces

import com.example.domain.models.Result
import com.example.domain.models.pets.UpdatePet
import kotlinx.coroutines.flow.Flow

interface UpdateNameStatusPetUseCase {
    fun execute(pet: UpdatePet): Flow<Result>
}