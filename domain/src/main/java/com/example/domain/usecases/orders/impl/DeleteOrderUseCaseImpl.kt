package com.example.domain.usecases.orders.impl

import com.example.domain.models.Result
import com.example.domain.repository_interfaces.OrderRepository
import com.example.domain.usecases.orders.interfaces.DeleteOrderUseCase
import kotlinx.coroutines.flow.Flow

class DeleteOrderUseCaseImpl(private val orderRepository: OrderRepository) : DeleteOrderUseCase {
    override fun execute(id: Long): Flow<Result> {
        return orderRepository.deleteOrderById(id = id)
    }
}