package com.example.domain.usecases.users.impl

import com.example.domain.models.Result
import com.example.domain.models.users.UserInfo
import com.example.domain.repository_interfaces.UserRepository
import com.example.domain.usecases.users.interfaces.CreateUserUseCase
import kotlinx.coroutines.flow.Flow

class CreateUserUseCaseImpl(private val repository: UserRepository) : CreateUserUseCase {
    override fun execute(user: UserInfo): Flow<Result> {
        return repository.createUser(user = user)
    }
}