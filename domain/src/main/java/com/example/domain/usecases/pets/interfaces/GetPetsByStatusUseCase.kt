package com.example.domain.usecases.pets.interfaces

import com.example.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface GetPetsByStatusUseCase {
    fun execute(status: String): Flow<Result>
}