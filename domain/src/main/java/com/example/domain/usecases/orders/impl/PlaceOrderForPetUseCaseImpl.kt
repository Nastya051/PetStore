package com.example.domain.usecases.orders.impl

import com.example.domain.models.Result
import com.example.domain.models.orders.OrderInfo
import com.example.domain.repository_interfaces.OrderRepository
import com.example.domain.usecases.orders.interfaces.PlaceOrderForPetUseCase
import kotlinx.coroutines.flow.Flow

class PlaceOrderForPetUseCaseImpl(private val orderRepository: OrderRepository) :
    PlaceOrderForPetUseCase {
    override fun execute(order: OrderInfo): Flow<Result> {
        return orderRepository.placeOrderForPet(orderInfo = order)
    }
}