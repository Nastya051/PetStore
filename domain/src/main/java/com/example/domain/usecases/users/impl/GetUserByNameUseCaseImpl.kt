package com.example.domain.usecases.users.impl

import com.example.domain.models.Result
import com.example.domain.repository_interfaces.UserRepository
import com.example.domain.usecases.users.interfaces.GetUserByNameUseCase
import kotlinx.coroutines.flow.Flow

class GetUserByNameUseCaseImpl(private val repository: UserRepository) : GetUserByNameUseCase {
    override fun execute(name: String): Flow<Result> {
        return repository.getUserByName(name = name)
    }
}