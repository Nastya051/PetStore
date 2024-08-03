package com.example.domain.repository_interfaces

import com.example.domain.models.Result
import com.example.domain.models.users.UserInfo
import com.example.domain.models.users.UserLogIn
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserByName(name: String): Flow<Result>

    fun updateUserByName(user: UserInfo): Flow<Result>

    fun deleteUserByName(name: String): Flow<Result>

    fun logIn(user: UserLogIn): Flow<Result>

    fun logOut(): Flow<Result>

    fun createUser(user: UserInfo): Flow<Result>
}