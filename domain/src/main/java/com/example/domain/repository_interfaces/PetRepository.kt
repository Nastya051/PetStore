package com.example.domain.repository_interfaces

import com.example.domain.models.pets.PetInfo
import com.example.domain.models.Result
import com.example.domain.models.pets.UpdatePet
import kotlinx.coroutines.flow.Flow

interface PetRepository {

    fun getPetsByStatus(status: String): Flow<Result>

    fun getPetById(id: Long): Flow<Result>

    fun addNewPetToStore(pet: PetInfo): Flow<Result>

    fun updatePet(pet: PetInfo): Flow<Result>

    fun updateNameAndStatusPet(pet: UpdatePet): Flow<Result>

    fun deletePet(id: Long): Flow<Result>
}