package com.example.data.services

import com.example.data.constants.NAME
import com.example.data.constants.STATUS
import com.example.domain.models.pets.PetInfo
import com.example.domain.models.pets.UpdatePet
import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.forms.formData
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

interface ApiServicePets {
    suspend fun getPetsByStatus(status: String): HttpResponse
    suspend fun getPetById(id: Long): HttpResponse
    suspend fun addNewPet(pet: PetInfo): HttpResponse
    suspend fun updateNameStatusPet(pet: UpdatePet): HttpResponse
    suspend fun updatePetInfo(pet: PetInfo): HttpResponse
    suspend fun deletePet(id: Long): HttpResponse
}

class ApiServicePetsImpl(private val client: HttpClient) : ApiServicePets {

    private val petsByStatus = "pet/findByStatus"
    private val petById = "pet/"

    override suspend fun getPetsByStatus(status: String): HttpResponse {
        return client.get(petsByStatus) {
            contentType(ContentType.Application.Json)
            parameter(STATUS, status)
        }
    }

    override suspend fun getPetById(id: Long): HttpResponse {
        return client.get(petById + id) {
            contentType(ContentType.Application.Json)
        }
    }

    override suspend fun addNewPet(pet: PetInfo): HttpResponse {
        return client.post(petById) {
            contentType(ContentType.Application.Json)
            setBody(pet)
        }
    }

    override suspend fun updateNameStatusPet(pet: UpdatePet): HttpResponse {
        return client.post(petById + pet.id) {
            contentType(ContentType.Application.FormUrlEncoded)
            formData {
                parameter(NAME, pet.name)
                parameter(STATUS, pet.status)
            }
        }
    }

    override suspend fun updatePetInfo(pet: PetInfo): HttpResponse {
        return client.put(petById) {
            contentType(ContentType.Application.Json)
            setBody(pet)
        }
    }

    override suspend fun deletePet(id: Long): HttpResponse {
        return client.delete(petById + id) {
            contentType(ContentType.Application.Json)
        }
    }

}