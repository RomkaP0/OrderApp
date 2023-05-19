package com.romka_po.orderapp.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.romka_po.orderapp.R


@Composable
fun Detail(detailID:Int) {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier =
            Modifier
            .padding(16.dp)
            .size(44.dp),
        shape = RoundedCornerShape(50.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrowleft),
            contentDescription = null,
            tint = Color.White,
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            painter = painterResource(id = R.drawable.photo),
            contentDescription = null
        )

        Column {
            Text(text = "Том Ям")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Кокосовое молоко, кальмары, креветки, помидоры черри, грибы вешанки")
        }

        Column {
            repeat(5) {
                Text(text = "1")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .shadow(10.dp, RoundedCornerShape(4.dp)),
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ },
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(vertical = 14.dp)
            ) {
                Icon(Icons.Default.ShoppingCart, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "2100")
            }
        }
    }
}
