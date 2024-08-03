package com.example.data.services

import com.example.domain.models.orders.OrderInfo
import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

interface ApiServiceOrders {
    suspend fun getOrder(id: Long): HttpResponse
    suspend fun placeOrder(orderInfo: OrderInfo): HttpResponse
    suspend fun deleteOrder(id: Long): HttpResponse
}

class ApiServiceOrdersImpl(private val client: HttpClient) : ApiServiceOrders {

    private val order = "store/order/"

    override suspend fun getOrder(id: Long): HttpResponse {
        return client.get(order + id) {
            contentType(ContentType.Application.Json)
        }
    }

    override suspend fun placeOrder(orderInfo: OrderInfo): HttpResponse {
        return client.post(order) {
            contentType(ContentType.Application.Json)
            setBody(orderInfo)
        }
    }

    override suspend fun deleteOrder(id: Long): HttpResponse {
        return client.delete(order + id) {
            contentType(ContentType.Application.Json)
        }
    }

}