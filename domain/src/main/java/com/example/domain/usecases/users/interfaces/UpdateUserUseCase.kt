package com.example.domain.usecases.users.interfaces

import com.example.domain.models.Result
import com.example.domain.models.users.UserInfo
import kotlinx.coroutines.flow.Flow

interface UpdateUserUseCase {
    fun execute(user: UserInfo): Flow<Result>
}