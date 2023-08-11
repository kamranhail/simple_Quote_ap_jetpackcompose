package com.example.cheezycodecompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cheezycodecompose.Modals.DataManager
import com.example.cheezycodecompose.Secreens.QuoteItemDetail
import com.example.cheezycodecompose.Secreens.QuoteListSecreen
import com.example.cheezycodecompose.ui.theme.CheezycodeComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch{
            delay(10000)
            DataManager.LoadAssetFromFile(applicationContext)
        }

        setContent {
App()
        }
    }
}


@Composable
fun App()
{

    if(DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListSecreen(date = DataManager.data) {
                // quote edr tk aa gya ha    ab edr set krwa do
                DataManager.SwithPages(it)
            }
        }else
        {
            DataManager.currentQuote?.let { QuoteItemDetail(quote = it) }
            // call detail page
        }
    }
    else{

        Box( contentAlignment =  Alignment.Center, modifier = Modifier.fillMaxSize(1f))
        {
    Text(text = "Loading",
    style = MaterialTheme.typography.headlineLarge
        )

        }

    }

}

enum class Pages{
    LISTING,DETAILS
}


