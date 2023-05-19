@file:OptIn(ExperimentalMaterial3Api::class)

package com.romka_po.orderapp.ui.common

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomFilterSheet(onDismissRequest: ()->Unit,){
    ModalBottomSheet(
//        modifier = Modifier.padding(horizontal = 24.dp, vertical = 32.dp),
        onDismissRequest = { onDismissRequest() }) {
            Text(text = "Подобрать блюда")
    }
}