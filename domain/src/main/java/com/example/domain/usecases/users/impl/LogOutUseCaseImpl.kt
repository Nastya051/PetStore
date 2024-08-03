package com.example.domain.usecases.users.impl

import com.example.domain.models.Result
import com.example.domain.repository_interfaces.UserRepository
import com.example.domain.usecases.users.interfaces.LogOutUseCase
import kotlinx.coroutines.flow.Flow

class LogOutUseCaseImpl(private val repository: UserRepository) : LogOutUseCase {
    override fun execute(): Flow<Result> {
        return repository.logOut()
    }
}