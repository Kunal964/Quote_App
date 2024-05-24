package com.example.quotecomponentapp

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.quotecomponentapp.screens.QuoteDetails
import com.example.quotecomponentapp.screens.QuoteListScreen
import com.example.quotecomponentapp.ui.theme.QuoteComponentAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Delay
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            Datamanager.loadAssetsfromFile(applicationContext)
        }

        enableEdgeToEdge()
        setContent {
            QuoteComponentAppTheme {
                SetStatusBarColor()
                App()
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App() = if (Datamanager.isDataLoaded.value) {
    Scaffold(
        topBar = {
            TopAppBar(
                { Text(text = stringResource(id = R.string.app_name)) },
                // Set ActionBar color
            )
        }
    ) {
        // Your content goes here
        // For example:
        if (Datamanager.CurrentPage.value == Pages.LISTING) {
            QuoteListScreen(data = Datamanager.data) {
                Datamanager.switchpages(it)
            }
        } else {
            Datamanager.currentQuote?.let { QuoteDetails(quote = it) }
        }
    }
} else {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)
    ){
        Text(
            text = "Loading...",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun SetStatusBarColor() {
    val statusBarColor = MaterialTheme.colorScheme.secondary.toArgb()

    val window = (LocalContext.current as? Activity)?.window
    window?.let {
        it.statusBarColor = statusBarColor
        val insetsController = WindowCompat.getInsetsController(it, it.decorView)
        insetsController.isAppearanceLightStatusBars = true // or false based on your theme
    }

}

enum class Pages{
    LISTING,
    DETAIL

}

