package com.example.petstore.di

import com.example.data.client.httpClientAndroid
import com.example.data.repository_impl.OrderRepositoryImpl
import com.example.data.repository_impl.PetRepositoryImpl
import com.example.data.repository_impl.UserRepositoryImpl
import com.example.data.services.ApiServiceOrders
import com.example.data.services.ApiServiceOrdersImpl
import com.example.data.services.ApiServicePets
import com.example.data.services.ApiServicePetsImpl
import com.example.data.services.ApiServiceUsers
import com.example.data.services.ApiServiceUsersImpl
import com.example.domain.repository_interfaces.OrderRepository
import com.example.domain.repository_interfaces.PetRepository
import com.example.domain.repository_interfaces.UserRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {

    //repositories
    single<PetRepository> {
        PetRepositoryImpl(apiService = get())
    }
    single<OrderRepository> {
        OrderRepositoryImpl(apiServiceOrders = get())
    }
    single<UserRepository> {
        UserRepositoryImpl(apiServiceUsers = get())
    }

    //services
    single<ApiServicePets> {
        ApiServicePetsImpl(client = get())
    }
    single<ApiServiceOrders> {
        ApiServiceOrdersImpl(client = get())
    }
    single<ApiServiceUsers> {
        ApiServiceUsersImpl(client = get())
    }

    single {
        provideHttpClient()
    }
}

fun provideHttpClient(): HttpClient {
    return httpClientAndroid
}