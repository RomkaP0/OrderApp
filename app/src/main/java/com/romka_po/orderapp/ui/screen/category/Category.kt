@file:OptIn(ExperimentalMaterial3Api::class)

package com.romka_po.orderapp.ui.screen.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.romka_po.orderapp.R


@Composable
fun Category() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom) {
            Icon(
                modifier = Modifier.padding(10.dp),
                contentDescription = null,

                painter = painterResource(id = R.drawable.filter),
            )
            Image(
                painter = painterResource(id = R.drawable.logo__1_),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.Red)
            )
            Icon(
                modifier = Modifier.padding(10.dp),
                painter = painterResource(id = R.drawable.search),
                tint = Color.Black,
                contentDescription = null
                )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier

                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            items(listOf("Gegeg", "gegegeg", "", "", "gegegeg", "gegegeg")) {
                Card(modifier = Modifier) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Box {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1f),
                                painter = painterResource(id = R.drawable.photo),
                                contentDescription = null
                            )
                            Image(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .size(24.dp),
                                painter = painterResource(id = R.drawable.spicy),
                                contentDescription = null
                            )
                        }

                        Column(Modifier.padding(12.dp)) {
                            Text(text = "Том Ям")
                            Text(
                                text = "500 г",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Button(
                                modifier = Modifier
                                    .padding(top = 12.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(8.dp),
                                onClick = { /*TODO*/ },
                            ) {
                                Text(text = "480 ₽")
                                Text(text = "520 ₽", textDecoration = TextDecoration.LineThrough)
                            }

                        }

                    }

                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .shadow(10.dp, RoundedCornerShape(4.dp)),
        ) {
            Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }, shape = RoundedCornerShape(8.dp), contentPadding = PaddingValues(vertical = 14.dp)) {
                Icon(Icons.Default.ShoppingCart, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "2100",)
            }

        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Test() {
    Category()
}

