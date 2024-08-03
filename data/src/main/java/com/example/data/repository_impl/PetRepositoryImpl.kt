package com.example.data.repository_impl

import com.example.data.services.ApiServicePets
import com.example.domain.models.CommonResponse
import com.example.domain.models.pets.PetInfo
import com.example.domain.models.Result
import com.example.domain.models.pets.UpdatePet
import com.example.domain.repository_interfaces.PetRepository
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerializationException

class PetRepositoryImpl(private val apiService: ApiServicePets) : PetRepository {
    override fun getPetsByStatus(status: String): Flow<Result> {
        return flow {
            val response = apiService.getPetsByStatus(status = status)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<List<PetInfo>>()))
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

    override fun getPetById(id: Long): Flow<Result> {
        return flow {
            val response = apiService.getPetById(id = id)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<PetInfo>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }

                    404 -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun addNewPetToStore(pet: PetInfo): Flow<Result> {
        return flow {
            val response = apiService.addNewPet(pet = pet)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<PetInfo>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }

                    405 -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun updatePet(pet: PetInfo): Flow<Result> {
        return flow {
            val response = apiService.updatePetInfo(pet = pet)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<PetInfo>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }

                    400, 404, 405 -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun updateNameAndStatusPet(pet: UpdatePet): Flow<Result> {
        return flow {
            val response = apiService.updateNameStatusPet(pet = pet)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<CommonResponse>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }

                    405, 415 -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun deletePet(id: Long): Flow<Result> {
        return flow {
            val response = apiService.deletePet(id = id)
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
}