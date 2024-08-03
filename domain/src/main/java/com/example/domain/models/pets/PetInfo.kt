package com.example.domain.models.pets

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PetInfo(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("category")
    val category: Category? = null,
    @SerialName("name")
    val name: String? = null,
    @SerialName("photoUrls")
    val photoUrls: List<String>,
    @SerialName("tags")
    val tags: List<Category>,
    @SerialName("status")
    val status: String
)

@Serializable
data class Category(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("name")
    val name: String = ""
)