package com.example.petstore.di

import com.example.domain.usecases.orders.impl.DeleteOrderUseCaseImpl
import com.example.domain.usecases.orders.impl.GetOrderByIdUseCaseImpl
import com.example.domain.usecases.orders.impl.PlaceOrderForPetUseCaseImpl
import com.example.domain.usecases.orders.interfaces.DeleteOrderUseCase
import com.example.domain.usecases.orders.interfaces.GetOrderByIdUseCase
import com.example.domain.usecases.orders.interfaces.PlaceOrderForPetUseCase
import com.example.domain.usecases.pets.impl.AddNewPetToStoreUseCaseImpl
import com.example.domain.usecases.pets.impl.DeletePetUseCaseImpl
import com.example.domain.usecases.pets.interfaces.GetPetByIdUseCase
import com.example.domain.usecases.pets.impl.GetPetByIdUseCaseImpl
import com.example.domain.usecases.pets.interfaces.GetPetsByStatusUseCase
import com.example.domain.usecases.pets.impl.GetPetsByStatusUseCaseImpl
import com.example.domain.usecases.pets.impl.UpdateNameStatusPetUseCaseImpl
import com.example.domain.usecases.pets.impl.UpdatePetInfoUseCaseImpl
import com.example.domain.usecases.pets.interfaces.AddNewPetToStoreUseCase
import com.example.domain.usecases.pets.interfaces.DeletePetUseCase
import com.example.domain.usecases.pets.interfaces.UpdateNameStatusPetUseCase
import com.example.domain.usecases.pets.interfaces.UpdatePetInfoUseCase
import com.example.domain.usecases.users.impl.CreateUserUseCaseImpl
import com.example.domain.usecases.users.impl.DeleteUserUseCaseImpl
import com.example.domain.usecases.users.impl.GetUserByNameUseCaseImpl
import com.example.domain.usecases.users.impl.LogInUseCaseImpl
import com.example.domain.usecases.users.impl.LogOutUseCaseImpl
import com.example.domain.usecases.users.impl.UpdateUserUseCaseImpl
import com.example.domain.usecases.users.interfaces.CreateUserUseCase
import com.example.domain.usecases.users.interfaces.DeleteUserUseCase
import com.example.domain.usecases.users.interfaces.GetUserByNameUseCase
import com.example.domain.usecases.users.interfaces.LogInUseCase
import com.example.domain.usecases.users.interfaces.LogOutUseCase
import com.example.domain.usecases.users.interfaces.UpdateUserUseCase
import org.koin.dsl.module

val domainModule = module {
    //pets
    factory<GetPetsByStatusUseCase> {
        GetPetsByStatusUseCaseImpl(repository = get())
    }
    factory<GetPetByIdUseCase> {
        GetPetByIdUseCaseImpl(repository = get())
    }
    factory<AddNewPetToStoreUseCase> {
        AddNewPetToStoreUseCaseImpl(repository = get())
    }
    factory<UpdatePetInfoUseCase> {
        UpdatePetInfoUseCaseImpl(repository = get())
    }
    factory<UpdateNameStatusPetUseCase> {
        UpdateNameStatusPetUseCaseImpl(repository = get())
    }
    factory<DeletePetUseCase> {
        DeletePetUseCaseImpl(repository = get())
    }

    //orders
    factory<GetOrderByIdUseCase> {
        GetOrderByIdUseCaseImpl(orderRepository = get())
    }
    factory<PlaceOrderForPetUseCase> {
        PlaceOrderForPetUseCaseImpl(orderRepository = get())
    }
    factory<DeleteOrderUseCase> {
        DeleteOrderUseCaseImpl(orderRepository = get())
    }

    //user
    factory<CreateUserUseCase> {
        CreateUserUseCaseImpl(repository = get())
    }
    factory<DeleteUserUseCase> {
        DeleteUserUseCaseImpl(repository = get())
    }
    factory<UpdateUserUseCase> {
        UpdateUserUseCaseImpl(repository = get())
    }
    factory<GetUserByNameUseCase> {
        GetUserByNameUseCaseImpl(repository = get())
    }
    factory<LogInUseCase> {
        LogInUseCaseImpl(repository = get())
    }
    factory<LogOutUseCase> {
        LogOutUseCaseImpl(repository = get())
    }
}