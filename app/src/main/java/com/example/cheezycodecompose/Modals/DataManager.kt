package com.example.cheezycodecompose.Modals

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.cheezycodecompose.Pages
import java.nio.charset.Charset
import com.google.gson.Gson

object DataManager {
    var currentPage = mutableStateOf(Pages.LISTING)
var data = emptyArray<Quote>()

var isDataLoaded= mutableStateOf(false)

var currentQuote : Quote?=null
    fun LoadAssetFromFile(context :Context)
    {
        val inputStream= context.
        assets.open("entequotes.json")
        val size: Int= inputStream.available()
        val buffer= ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json=String(buffer, Charsets.UTF_8)
        val gson= Gson()
        data=gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value=true


    }

     fun SwithPages(quote: Quote?)
     {
         if(currentPage.value==Pages.LISTING)
         {
             currentQuote=quote
             currentPage.value=Pages.DETAILS
         }else
         {
             currentPage.value=Pages.LISTING
         }
     }

}