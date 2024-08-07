package com.example.petstore.presentation.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.models.pets.Category
import com.example.domain.models.pets.PetInfo
import com.example.petstore.R
import com.example.petstore.presentation.ui.custom_views.CommonTopBar
import com.example.petstore.presentation.ui.custom_views.cards.PetCard
import kotlin.random.Random

@Composable
fun MainScreen() {
    val items = List(10) {
        PetInfo(
            name = "Name",
            photoUrls = listOf(""),
            tags = listOf(Category()),
            status = "available"
        )
    }
    Scaffold(
        topBar = {
            CommonTopBar(
                leftIcon = R.drawable.ic_heart_512,
                onClickLeft = { /*на страницу отданных животных*/ },
                rightIcon = R.drawable.ic_user_416,
                onClickRight = { /*на профиль юзера*/ })
        },
        containerColor = MaterialTheme.colorScheme.background
    ) {
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(it)) {
            items(count = items.size) { pet ->
                PetCard(
                    petInfo = items[pet],
                    image = getRandomImage(),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
            }
        }
    }
}

//т.к. в структуру редко записывают ссылку на фото животного, то я его генерирую рандомно
private fun getRandomImage(): Int {
    val images = listOf(
        R.drawable.bird,
        R.drawable.bird_2,
        R.drawable.dog,
        R.drawable.dog_2,
        R.drawable.cat,
        R.drawable.cat_2,
        R.drawable.ferret,
        R.drawable.ferret_2,
        R.drawable.guinea_pig,
        R.drawable.rabbit,
        R.drawable.turtle
    )
    val randomIndex = Random.nextInt(images.size)

    return images[randomIndex]
}