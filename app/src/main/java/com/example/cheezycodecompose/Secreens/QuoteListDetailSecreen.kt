package com.example.cheezycodecompose.Secreens
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cheezycodecompose.Modals.DataManager
import com.example.cheezycodecompose.Modals.Quote
import com.example.cheezycodecompose.R

@Composable
fun QuoteItemDetail(quote: Quote){
BackHandler() {
    DataManager.SwithPages(null)
}
    
    Box( contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1.0f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color.LightGray, Color(0xffd9ead3)
                    )
                )
            )
    )
    {
        Card(elevation =CardDefaults.cardElevation(defaultElevation = 5.dp)
            , modifier = Modifier
                .padding(5.dp)



        ){
            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(20.dp, 20.dp, 20.dp, 20.dp) ,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

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
                Text(text =quote.from,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight= FontWeight.Thin,
                    modifier = Modifier.padding(0.dp,5.dp,0.dp,0.dp)
                )
            }
        }
    }
}