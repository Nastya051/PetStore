package com.example.domain.usecases.users.interfaces

import com.example.domain.models.Result
import com.example.domain.models.users.UserLogIn
import kotlinx.coroutines.flow.Flow

interface LogInUseCase {
    fun execute(user: UserLogIn): Flow<Result>
}