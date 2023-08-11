package com.example.cheezycodecompose.Secreens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cheezycodecompose.Modals.Quote
import com.example.cheezycodecompose.R


@Composable
fun QuoteLisItem(quote :Quote ,onClick : (quote :Quote) -> Unit) {
   Card(elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
      , modifier = Modifier.padding(5.dp).clickable { onClick(quote) }

   ) {
       Row(
           Modifier
               .padding(5.dp)
               .height(10.dp),
           verticalAlignment = Alignment.Top

       ) {
           Image(painter = painterResource(id = R.drawable.quote_24), contentDescription = "Quote")
           Text(text = "...", color = Color.Black, textAlign = TextAlign.Center, fontSize = 6.sp)
       }
       Row(
           Modifier
               .padding(5.dp)

       ) {
           Image(
               imageVector = Icons.Filled.FormatQuote,
               contentDescription = "Quote",
               colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White),
               alignment = Alignment.TopStart,
               modifier = Modifier
                   .size(40.dp)
                   .background(Color.Black)
                   .rotate(180f)

           )
           Spacer(modifier = Modifier.padding(3.dp))
           Column(modifier = Modifier.weight(1f)) {
               Text(text = quote.text

                   ,style = MaterialTheme.typography.bodyMedium
               , fontFamily = FontFamily(Font(R.font.newfont))
               )
Box(
    Modifier
        .background(Color.LightGray)
        .fillMaxWidth(0.4f)
        .height(1.dp)
        .padding(1.dp)
        .padding(0.dp, 2.dp, 0.dp, 0.dp)
) {

}
               Text(text = quote.from,
                   style = MaterialTheme.typography.bodyLarge,
                   fontWeight= FontWeight.Thin,
                   modifier = Modifier.padding(0.dp,5.dp,0.dp,0.dp)
                       )
           }
       }
       Row(
           Modifier
               .fillMaxWidth()
               .padding(5.dp)
               .height(10.dp),
           verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.End

       ) {
           Image(painter = painterResource(id = R.drawable.quote_24), contentDescription = "Quote")

       }


   }
}

