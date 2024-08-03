package com.example.domain.repository_interfaces

import com.example.domain.models.Result
import com.example.domain.models.orders.OrderInfo
import kotlinx.coroutines.flow.Flow

interface OrderRepository {

    fun getOrderById(id: Long): Flow<Result>

    fun placeOrderForPet(orderInfo: OrderInfo): Flow<Result>

    fun deleteOrderById(id: Long): Flow<Result>
}