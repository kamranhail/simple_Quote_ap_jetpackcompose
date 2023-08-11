package com.example.cheezycodecompose.Secreens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.cheezycodecompose.Modals.Quote

// edr sy b onlick  lamda pass kr k  agy ja k body define hogi  phly item sy phir yaha sy
@Composable
fun QuoteList(data : Array<Quote>,onClick :(qoute:Quote)-> Unit) {
   LazyColumn(content = {
       items(data){
           QuoteLisItem(it,onClick)
       }

   })
}