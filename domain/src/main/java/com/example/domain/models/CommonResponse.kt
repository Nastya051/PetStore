package com.example.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommonResponse(
    @SerialName("code")
    val code: Long,
    @SerialName("type")
    val type: String,
    @SerialName("message")
    val message: String? = null
)