package com.example.domain.usecases.users.impl

import com.example.domain.models.Result
import com.example.domain.repository_interfaces.UserRepository
import com.example.domain.usecases.users.interfaces.DeleteUserUseCase
import kotlinx.coroutines.flow.Flow

class DeleteUserUseCaseImpl(private val repository: UserRepository) : DeleteUserUseCase {
    override fun execute(name: String): Flow<Result> {
        return repository.deleteUserByName(name = name)
    }
}