package com.example.petstore.di

import com.example.petstore.viewmodels.OrderViewModel
import com.example.petstore.viewmodels.PetsViewModel
import com.example.petstore.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<PetsViewModel> {
        PetsViewModel(
            getPetsByStatusUseCase = get(),
            getPetByIdUseCase = get(),
            addNewPetToStoreUseCase = get(),
            updatePetInfoUseCase = get(),
            updateNameStatusPetUseCase = get(),
            deletePetUseCase = get()
        )
    }

    viewModel<OrderViewModel> {
        OrderViewModel(
            getOrderByIdUseCase = get(),
            placeOrderForPetUseCase = get(),
            deleteOrderUseCase = get()
        )
    }

    viewModel<UserViewModel> {
        UserViewModel(
            createUserUseCase = get(),
            deleteUserUseCase = get(),
            getUserByNameUseCase = get(),
            updateUserUseCase = get(),
            logInUseCase = get(),
            logOutUseCase = get()
        )
    }
}