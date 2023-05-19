package com.romka_po.orderapp.adapters

import androidx.navigation.NavHostController
import com.romka_po.orderapp.model.Destinations

class Actions(navController: NavHostController) {
    val detailScreen: (Int) -> Unit = { detailId ->
        navController.navigate("${Destinations.Detail}/$detailId")
    }
    val categoryScreen: () -> Unit = {
        navController.navigate(Destinations.Category)
    }
    val navigateBack: () -> Unit = {
        navController.popBackStack()
    }
}