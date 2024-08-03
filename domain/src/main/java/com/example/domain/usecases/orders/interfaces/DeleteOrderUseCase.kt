package com.example.domain.usecases.orders.interfaces

import com.example.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface DeleteOrderUseCase {
    fun execute(id: Long): Flow<Result>
}