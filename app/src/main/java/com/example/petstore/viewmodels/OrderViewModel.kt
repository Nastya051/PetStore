package com.example.petstore.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.CommonResponse
import com.example.domain.models.Result
import com.example.domain.models.orders.OrderInfo
import com.example.domain.usecases.orders.interfaces.DeleteOrderUseCase
import com.example.domain.usecases.orders.interfaces.GetOrderByIdUseCase
import com.example.domain.usecases.orders.interfaces.PlaceOrderForPetUseCase
import kotlinx.coroutines.launch

class OrderViewModel(
    private val getOrderByIdUseCase: GetOrderByIdUseCase,
    private val placeOrderForPetUseCase: PlaceOrderForPetUseCase,
    private val deleteOrderUseCase: DeleteOrderUseCase
) : ViewModel() {

    init {
//        getOrderById(3)
//        deleteOrder(3)
//        placeOrder(
//            OrderInfo(
//                petID = 1,
//                quantity = 1,
//                shipDate = "2024-08-02",
//                status = "placed",
//                complete = true
//            )
//        )
    }

    fun getOrderById(id: Long) {
        val response = getOrderByIdUseCase.execute(id = id)
        viewModelScope.launch {
            response.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saved = it.copy().value as OrderInfo
                        Log.d("MyLog", "Success!!!")
                        Log.d("MyLog", saved.id.toString() + " " + saved.petID.toString())

                    }

                    is Result.Error -> {
                        val saved = it.copy().value
                        Log.d("MyLog", "Error " + saved.message)
                    }

                    is Result.ErrorNetwork -> {
                        Log.d("MyLog", "ErrorNetwork " + it.value.message)
                    }
                }
            }
        }
    }

    fun deleteOrder(id: Long) {
        val response = deleteOrderUseCase.execute(id = id)
        viewModelScope.launch {
            response.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saved = it.copy().value as CommonResponse
                        Log.d("MyLog", "Success!!!")
                        Log.d("MyLog", saved.code.toString())

                    }

                    is Result.Error -> {
                        val saved = it.copy().value
                        Log.d("MyLog", "Error " + saved.message)
                    }

                    is Result.ErrorNetwork -> {
                        Log.d("MyLog", "ErrorNetwork " + it.value.message)
                    }
                }
            }
        }
    }

    fun placeOrder(orderInfo: OrderInfo) {
        val response = placeOrderForPetUseCase.execute(order = orderInfo)
        viewModelScope.launch {
            response.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saved = it.copy().value as OrderInfo
                        Log.d("MyLog", "Success!!!")
                        Log.d("MyLog", saved.id.toString() + " " + saved.status)

                    }

                    is Result.Error -> {
                        val saved = it.copy().value
                        Log.d("MyLog", "Error " + saved.message)
                    }

                    is Result.ErrorNetwork -> {
                        Log.d("MyLog", "ErrorNetwork " + it.value.message)
                    }
                }
            }
        }
    }
}