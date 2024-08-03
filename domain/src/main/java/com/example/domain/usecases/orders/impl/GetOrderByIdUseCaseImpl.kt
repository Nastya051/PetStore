package com.example.domain.usecases.orders.impl

import com.example.domain.models.Result
import com.example.domain.repository_interfaces.OrderRepository
import com.example.domain.usecases.orders.interfaces.GetOrderByIdUseCase
import kotlinx.coroutines.flow.Flow

class GetOrderByIdUseCaseImpl(private val orderRepository: OrderRepository) : GetOrderByIdUseCase {
    override fun execute(id: Long): Flow<Result> {
        return orderRepository.getOrderById(id = id)
    }
}