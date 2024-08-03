package com.example.data.repository_impl

import com.example.data.services.ApiServiceOrders
import com.example.domain.models.CommonResponse
import com.example.domain.models.Result
import com.example.domain.models.orders.OrderInfo
import com.example.domain.repository_interfaces.OrderRepository
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerializationException

class OrderRepositoryImpl(private val apiServiceOrders: ApiServiceOrders) : OrderRepository {
    override fun getOrderById(id: Long): Flow<Result> {
        return flow {
            val response = apiServiceOrders.getOrder(id = id)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<OrderInfo>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }
                    400, 404 -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun placeOrderForPet(orderInfo: OrderInfo): Flow<Result> {
        return flow {
            val response = apiServiceOrders.placeOrder(orderInfo = orderInfo)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<OrderInfo>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }
                    400 -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }

    override fun deleteOrderById(id: Long): Flow<Result> {
        return flow {
            val response = apiServiceOrders.deleteOrder(id = id)
            try {
                when (response.status.value) {
                    200 -> {
                        try {
                            emit(Result.Success(value = response.body<CommonResponse>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = e))
                        }
                    }
                    400, 404 -> emit(Result.Error(value = response.body<CommonResponse>()))
                }
            } catch (e: Exception) {
                emit(Result.ErrorNetwork(value = e))
            }
        }
    }
}