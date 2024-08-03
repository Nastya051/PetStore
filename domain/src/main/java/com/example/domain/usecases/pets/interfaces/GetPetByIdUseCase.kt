package com.example.domain.usecases.pets.interfaces

import com.example.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface GetPetByIdUseCase {
    fun execute(id: Long): Flow<Result>
}