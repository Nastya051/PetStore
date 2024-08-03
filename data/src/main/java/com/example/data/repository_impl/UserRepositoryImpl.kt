package com.example.data.repository_impl

import com.example.data.services.ApiServiceUsers
import com.example.domain.models.CommonResponse
import com.example.domain.models.Result
import com.example.domain.models.users.UserInfo
import com.example.domain.models.users.UserLogIn
import com.example.domain.repository_interfaces.UserRepository
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerializationException

class UserRepositoryImpl(private val apiServiceUsers: ApiServiceUsers) : UserRepository {
    override fun getUserByName(name: String): Flow<Result> {
        return flow {
            val response = apiServiceUsers.getUser(name = name)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<UserInfo>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }

                    400, 404 -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun updateUserByName(user: UserInfo): Flow<Result> {
        return flow {
            val response = apiServiceUsers.updateUser(userInfo = user)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<CommonResponse>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }

                    400, 404 -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun deleteUserByName(name: String): Flow<Result> {
        return flow {
            val response = apiServiceUsers.deleteUser(name = name)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<CommonResponse>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }

                    400, 404 -> emit(Result.ErrorNetwork(value = Exception()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun logIn(user: UserLogIn): Flow<Result> {
        return flow {
            val response = apiServiceUsers.logIn(userLogIn = user)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<CommonResponse>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }

                    400 -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun logOut(): Flow<Result> {
        return flow {
            val response = apiServiceUsers.logOut()
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<CommonResponse>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }

                    else -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun createUser(user: UserInfo): Flow<Result> {
        return flow {
            val response = apiServiceUsers.createUser(userInfo = user)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<CommonResponse>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }

                    else -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }
}