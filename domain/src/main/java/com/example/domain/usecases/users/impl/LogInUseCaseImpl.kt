package com.example.domain.usecases.users.impl

import com.example.domain.models.Result
import com.example.domain.models.users.UserLogIn
import com.example.domain.repository_interfaces.UserRepository
import com.example.domain.usecases.users.interfaces.LogInUseCase
import kotlinx.coroutines.flow.Flow

class LogInUseCaseImpl(private val repository: UserRepository) : LogInUseCase {
    override fun execute(user: UserLogIn): Flow<Result> {
        return repository.logIn(user = user)
    }
}