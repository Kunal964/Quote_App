package com.example.quotecomponentapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotecomponentapp.models.Quote


@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    Column() {
        Text(
            text = " ",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 40.dp)
                .padding(20.dp, 24.dp),
        )
        QuoteList(data = data, onClick)

    }
}
