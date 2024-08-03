package com.example.data.services

import com.example.data.constants.PASSWORD
import com.example.data.constants.USERNAME
import com.example.domain.models.users.UserInfo
import com.example.domain.models.users.UserLogIn
import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType

interface ApiServiceUsers {
    suspend fun createUser(userInfo: UserInfo): HttpResponse
    suspend fun deleteUser(name: String): HttpResponse
    suspend fun getUser(name: String): HttpResponse
    suspend fun updateUser(userInfo: UserInfo): HttpResponse
    suspend fun logIn(userLogIn: UserLogIn): HttpResponse
    suspend fun logOut(): HttpResponse
}

class ApiServiceUsersImpl(private val client: HttpClient) : ApiServiceUsers {

    private val user = "user/"
    private val logIn = "user/login/"
    private val logOut = "user/logout/"

    override suspend fun createUser(userInfo: UserInfo): HttpResponse {
        return client.post(user) {
            contentType(ContentType.Application.Json)
            setBody(userInfo)
        }
    }

    override suspend fun deleteUser(name: String): HttpResponse {
        return client.delete(user + name) {
            contentType(ContentType.Application.Json)
        }
    }

    override suspend fun getUser(name: String): HttpResponse {
        return client.get(user + name) {
            contentType(ContentType.Application.Json)
        }
    }

    override suspend fun updateUser(userInfo: UserInfo): HttpResponse {
        return client.put(user + userInfo.username) {
            contentType(ContentType.Application.Json)
            setBody(userInfo)
        }
    }

    override suspend fun logIn(userLogIn: UserLogIn): HttpResponse {
        return client.get(logIn) {
            contentType(ContentType.Application.Json)
            parameter(USERNAME, userLogIn.username)
            parameter(PASSWORD, userLogIn.password)
        }
    }

    override suspend fun logOut(): HttpResponse {
        return client.get(logOut) {
            contentType(ContentType.Application.Json)
        }
    }

}