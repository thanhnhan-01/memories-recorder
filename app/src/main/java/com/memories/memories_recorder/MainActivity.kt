package com.memories.memories_recorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.memories.memories_recorder.navigation.AppNavGraph
import com.memories.memories_recorder.ui.theme.MemoriesRecorderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        var isLoading = true
//
//        splashScreen.setKeepOnScreenCondition {
//            isLoading
//        }

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition {
            false
        }

        enableEdgeToEdge()

        setContent {
            MemoriesRecorderTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    AppNavGraph(navController = navController)
}