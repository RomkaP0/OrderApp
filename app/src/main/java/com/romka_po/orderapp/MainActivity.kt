package com.romka_po.orderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.romka_po.orderapp.adapters.Actions
import com.romka_po.orderapp.model.Destinations
import com.romka_po.orderapp.model.Destinations.DetailArgs.DetailId
import com.romka_po.orderapp.ui.detail.Detail
import com.romka_po.orderapp.ui.screen.category.Category
import com.romka_po.orderapp.ui.theme.OrderAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val actions = remember(navController) { Actions(navController) }

            OrderAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Destinations.apply {
                        NavHost(navController = navController, startDestination = Category) {
                            composable(Category) {
                                Category(toDetail = actions.detailScreen)
                            }
                            composable("$Detail/$DetailId", arguments = listOf(navArgument(DetailId){type = NavType.IntType})) {
                                Detail(
                                    detailID = it.arguments?.getInt(DetailId) ?: 0)
                            }

                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OrderAppTheme {
    }
}