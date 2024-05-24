package com.example.quotecomponentapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotecomponentapp.models.Quote


@Composable
fun QuoteList(data: kotlin.Array<Quote>, onclick: (quote: Quote)-> Unit){
    LazyColumn(content = {
        items(data){
            QuoteListItem(quote = it, onclick)
        }
    })
}