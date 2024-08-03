package com.example.petstore.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.CommonResponse
import com.example.domain.models.pets.PetInfo
import com.example.domain.models.Result
import com.example.domain.models.pets.UpdatePet
import com.example.domain.usecases.pets.interfaces.AddNewPetToStoreUseCase
import com.example.domain.usecases.pets.interfaces.DeletePetUseCase
import com.example.domain.usecases.pets.interfaces.GetPetByIdUseCase
import com.example.domain.usecases.pets.interfaces.GetPetsByStatusUseCase
import com.example.domain.usecases.pets.interfaces.UpdateNameStatusPetUseCase
import com.example.domain.usecases.pets.interfaces.UpdatePetInfoUseCase
import kotlinx.coroutines.launch

class PetsViewModel(
    private val getPetsByStatusUseCase: GetPetsByStatusUseCase,
    private val getPetByIdUseCase: GetPetByIdUseCase,
    private val addNewPetToStoreUseCase: AddNewPetToStoreUseCase,
    private val updatePetInfoUseCase: UpdatePetInfoUseCase,
    private val updateNameStatusPetUseCase: UpdateNameStatusPetUseCase,
    private val deletePetUseCase: DeletePetUseCase
) : ViewModel() {

    init {
//        getPetsByStatus(status = "sold")
//        getPetById(575)
//        addNewPet(
//            PetInfo(
//                id = 7711111111111111111,
//                name = "pesiki2",
//                photoUrls = listOf(""),
//                tags = listOf(Category(id = 1, name = "str")),
//                status = "available"
//            )
//        )
//        updateNameStatusPet(UpdatePet(id = 7711111111111111111, name = "aaaaa", status = "sold"))
//        deletePet(7711111111111111111)
    }

    fun getPetsByStatus(status: String) {
        val response = getPetsByStatusUseCase.execute(status = status)
        viewModelScope.launch {
            response.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saved = it.copy().value as List<PetInfo>
                        Log.d("MyLog", "Success!!!")
                        for (i in saved) {
                            i.name?.let { it1 -> Log.d("MyLog", it1) }
                            Log.d("MyLog", i.id.toString())
                        }
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

    fun getPetById(id: Long) {
        val response = getPetByIdUseCase.execute(id = id)
        viewModelScope.launch {
            response.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saved = it.copy().value as PetInfo
                        Log.d("MyLog", "Success!!!")
                        saved.name?.let { it1 -> Log.d("MyLog", it1) }
                        Log.d("MyLog", saved.id.toString())

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

    fun addNewPet(pet: PetInfo) {
        val response = addNewPetToStoreUseCase.execute(pet = pet)
        viewModelScope.launch {
            response.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saved = it.copy().value as PetInfo
                        Log.d("MyLog", "Success!!!")
                        saved.name?.let { it1 -> Log.d("MyLog", it1) }
                        Log.d("MyLog", saved.id.toString())

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

    fun updatePetInfo(pet: PetInfo) {
        val response = updatePetInfoUseCase.execute(pet = pet)
        viewModelScope.launch {
            response.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saved = it.copy().value as PetInfo
                        Log.d("MyLog", "Success!!!")
                        saved.name?.let { it1 -> Log.d("MyLog", it1) }
                        Log.d("MyLog", saved.id.toString())

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

    fun updateNameStatusPet(pet: UpdatePet) {
        val response = updateNameStatusPetUseCase.execute(pet = pet)
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
                        Log.d("MyLog", "Error " + saved.code)
                    }

                    is Result.ErrorNetwork -> {
                        Log.d("MyLog", "ErrorNetwork " + it.value.message)
                    }
                }
            }
        }
    }

    fun deletePet(id: Long) {
        val response = deletePetUseCase.execute(id=id)
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
                        Log.d("MyLog", "Error " + saved.code)
                    }

                    is Result.ErrorNetwork -> {
                        Log.d("MyLog", "ErrorNetwork " + it.value.message)
                    }
                }
            }
        }
    }
}