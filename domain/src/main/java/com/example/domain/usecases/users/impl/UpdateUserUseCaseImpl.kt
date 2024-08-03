package com.example.domain.usecases.users.impl

import com.example.domain.models.Result
import com.example.domain.models.users.UserInfo
import com.example.domain.repository_interfaces.UserRepository
import com.example.domain.usecases.users.interfaces.UpdateUserUseCase
import kotlinx.coroutines.flow.Flow

class UpdateUserUseCaseImpl(private val repository: UserRepository) : UpdateUserUseCase {
    override fun execute(user: UserInfo): Flow<Result> {
        return repository.updateUserByName(user = user)
    }
}