package com.romka_po.orderapp.ui.screen.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.romka_po.orderapp.R
import org.jetbrains.annotations.TestOnly


@Composable
fun Detail(){
    FloatingActionButton(onClick = { /*TODO*/ },modifier = Modifier.padding(16.dp).size(44.dp), shape = RoundedCornerShape(50.dp)) {
        Icon(painter = painterResource(id = R.drawable.arrowleft), contentDescription = null)

    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                painter = painterResource(id = R.drawable.photo),
                contentDescription = null
            )

        }

    }
}

@Preview
@Composable
fun TestDetail(){
    Detail()
}