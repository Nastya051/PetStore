package com.example.petstore.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.CommonResponse
import com.example.domain.models.Result
import com.example.domain.models.orders.OrderInfo
import com.example.domain.models.users.UserInfo
import com.example.domain.models.users.UserLogIn
import com.example.domain.usecases.users.interfaces.CreateUserUseCase
import com.example.domain.usecases.users.interfaces.DeleteUserUseCase
import com.example.domain.usecases.users.interfaces.GetUserByNameUseCase
import com.example.domain.usecases.users.interfaces.LogInUseCase
import com.example.domain.usecases.users.interfaces.LogOutUseCase
import com.example.domain.usecases.users.interfaces.UpdateUserUseCase
import kotlinx.coroutines.launch

class UserViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    private val getUserByNameUseCase: GetUserByNameUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val logInUseCase: LogInUseCase,
    private val logOutUseCase: LogOutUseCase
) : ViewModel() {

    init {
//        createUser(
//            UserInfo(
//                username = "name1",
//                firstName = "firstName",
//                lastName = "lastName",
//                email = "email@email.com",
//                password = "password",
//                phone = "112233",
//                userStatus = 0
//            )
//        )
//        getUser("name1")
        deleteUser("name3")
//        updateUser(
//                        UserInfo(
//                username = "name1",
//                firstName = "firstName2",
//                lastName = "lastName2",
//                email = "email2@email.com",
//                password = "password2",
//                phone = "112233",
//                userStatus = 0
//            )
//        )
//        logIn(UserLogIn(username = "name1", password = "111"))
//        logOut()
    }

    fun createUser(user: UserInfo) {
        val response = createUserUseCase.execute(user = user)
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

    fun getUser(name: String) {
        val response = getUserByNameUseCase.execute(name = name)
        viewModelScope.launch {
            response.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saved = it.copy().value as UserInfo
                        Log.d("MyLog", "Success!!!")
                        Log.d("MyLog", saved.firstName + " " + saved.lastName)

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

    fun deleteUser(name: String) {
        val response = deleteUserUseCase.execute(name = name)
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
                        if (it.value.message != null)
                            Log.d("MyLog", "ErrorNetwork " + it.value.message)
                        else
                            Log.d(
                                "MyLog",
                                "ErrorNetwork " + "попытка удалить несуществующего пользователя"
                            )
                    }
                }
            }
        }
    }

    fun updateUser(user: UserInfo) {
        val response = updateUserUseCase.execute(user = user)
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

    fun logIn(user: UserLogIn) {
        val response = logInUseCase.execute(user = user)
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

    fun logOut() {
        val response = logOutUseCase.execute()
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
}