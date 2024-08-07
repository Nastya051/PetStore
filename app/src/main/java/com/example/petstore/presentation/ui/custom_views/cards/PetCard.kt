package com.example.petstore.presentation.ui.custom_views.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.domain.models.pets.PetInfo
import com.example.petstore.R
import com.example.petstore.presentation.ui.custom_views.buttons.CommonButton

@Composable
fun PetCard(modifier: Modifier = Modifier, petInfo: PetInfo, image: Int) {
    val takeStr = stringResource(id = R.string.take)
    val cancelStr = stringResource(id = R.string.cancel)
    var textButton by remember { mutableStateOf(takeStr) }
    Card(
        onClick = { /*на страницу с животным*/ },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onBackground),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = image), contentDescription = "Pet photo",
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp)
            )
            Text(
                text = petInfo.name ?: "No name", color = MaterialTheme.colorScheme.onTertiary,
                fontWeight = FontWeight.W600
            )
            CommonButton(
                text = textButton, onClick = { /*запрос на оформление/удаление заказа*/
                    //вынести в мейн
                    textButton = if (textButton == cancelStr) takeStr else cancelStr
                },
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
            )
        }
    }
}