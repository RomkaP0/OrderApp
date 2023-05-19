@file:OptIn(ExperimentalMaterial3Api::class)

package com.romka_po.orderapp.ui.screen.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.romka_po.orderapp.R
import com.romka_po.orderapp.ui.common.BottomButton
import com.romka_po.orderapp.ui.common.BottomFilterSheet
import com.romka_po.orderapp.ui.common.PlusMinusCount


@Composable
fun Category(categoryViewModel: CategoryViewModel = hiltViewModel(), toDetail: (Int) -> Unit) {
    val products by categoryViewModel.products.observeAsState(listOf())
    val categories by categoryViewModel.categories.observeAsState(listOf())
    val selectedProducts by categoryViewModel.selectedProducts.observeAsState(mapOf())
    var isFilterOpened by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            IconButton(modifier = Modifier.size(44.dp),
                onClick = { isFilterOpened = true }) {
                Icon(
                    contentDescription = null,
                    painter = painterResource(id = R.drawable.filter)
                )
            }
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
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) {
                SuggestionChip(onClick = { /*TODO*/ }, label = { Text(text = it.name.toString()) })
            }
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
            items(products) {
                Card(modifier = Modifier.clickable {
                    toDetail(1)
                }) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Box {
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1f),
                                painter = painterResource(id = R.drawable.photo),
                                contentDescription = null
                            )
                            if (it.tagIds.isNotEmpty())
                                Image(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .size(24.dp),
                                    painter = painterResource(id = R.drawable.spicy),
                                    contentDescription = null
                                )
                        }

                        Column(Modifier.padding(12.dp)) {
                            Text(
                                text = it.name.toString(),
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                            Text(
                                text = "${it.measure} ${it.measureUnit}",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            if (selectedProducts.containsKey(it.id)) {
                                PlusMinusCount({ categoryViewModel.changeValue(it.id!!,it.priceCurrent!!,true) },
                                    { categoryViewModel.changeValue(it.id!!,it.priceCurrent!!,false) },selectedProducts[it.id]!!)
                            } else {
                                Button(
                                    modifier = Modifier
                                        .padding(top = 12.dp)
                                        .fillMaxWidth(),
                                    shape = RoundedCornerShape(8.dp),
                                    onClick = {
                                        it.id?.let { it1 ->
                                            categoryViewModel.changeValue(
                                                it1, it.priceCurrent!!, true
                                            )
                                        }
                                    },
                                ) {
                                    Text(text = "${it.priceCurrent.toString()} ₽")
                                    if (it.priceOld != null) {
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "${it.priceOld.toString()} ₽",
                                            textDecoration = TextDecoration.LineThrough
                                        )
                                    }
                                }
                            }

                        }

                    }

                }

            }

        }
        if (selectedProducts.isNotEmpty()) {
            BottomButton()
        }
    }
    if (isFilterOpened) {
        BottomFilterSheet(onDismissRequest = { isFilterOpened = false })
    }

}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun Test() {
//    Category()
//}

