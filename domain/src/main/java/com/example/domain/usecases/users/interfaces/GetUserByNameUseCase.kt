package com.example.domain.usecases.users.interfaces

import com.example.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface GetUserByNameUseCase {
    fun execute(name: String): Flow<Result>
}