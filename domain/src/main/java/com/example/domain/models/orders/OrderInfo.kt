package com.example.domain.models.orders

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrderInfo(
    @SerialName("id")
    val id: Long = 0,
    @SerialName("petId")
    val petID: Long,
    @SerialName("quantity")
    val quantity: Long,
    @SerialName("shipDate")
    val shipDate: String,
    @SerialName("status")
    val status: String,
    @SerialName("complete")
    val complete: Boolean
)
