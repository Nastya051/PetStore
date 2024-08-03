package com.example.domain.models.pets

data class UpdatePet(
    val id: Long,
    val name: String,
    val status: String
)