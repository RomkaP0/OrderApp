package com.romka_po.orderapp.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.romka_po.orderapp.R

@Composable
fun PlusMinusCount(
    actionPlus:()->Unit,
    actionMinus:()->Unit,
    value:Int

) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(width = 146.dp)
    ) {
        IconButton(
            onClick = { actionMinus()
                      },
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .background(color = Color.White)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.minus),
                contentDescription = "Minus",
                tint = Color(0xfff15412)
            )
        }
        Spacer(
            modifier = Modifier
                .width(width = 12.dp)
        )
        Text(
            text = value.toString(),
            color = Color.Black.copy(alpha = 0.87f),
            textAlign = TextAlign.Center,
            lineHeight = 16.sp,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier
                .width(width = 42.dp)
        )
        Spacer(
            modifier = Modifier
                .width(width = 12.dp)
        )
        IconButton(
            onClick = { actionPlus()},
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .background(color = Color.White)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = "Plus",
                tint = Color(0xfff15412)
            )
        }
    }
}
