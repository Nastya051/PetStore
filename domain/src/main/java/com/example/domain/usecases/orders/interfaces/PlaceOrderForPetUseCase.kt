package com.example.domain.usecases.orders.interfaces

import com.example.domain.models.Result
import com.example.domain.models.orders.OrderInfo
import kotlinx.coroutines.flow.Flow

interface PlaceOrderForPetUseCase {
    fun execute(order: OrderInfo): Flow<Result>
}