package com.example.quotecomponentapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotecomponentapp.models.Quote
import com.google.gson.Gson
import java.nio.charset.StandardCharsets

object Datamanager
{
    var data = emptyArray<Quote>()
    var currentQuote: Quote? = null
    var CurrentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)
    fun loadAssetsfromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val jason = String(buffer, StandardCharsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(jason, Array<Quote>::class.java)
        isDataLoaded.value = true


    }
    fun switchpages(quote: Quote?){
        if(CurrentPage.value == Pages.LISTING){
            currentQuote = quote
            CurrentPage.value = Pages.DETAIL
        }else{
            CurrentPage.value = Pages.LISTING
        }
    }
}
