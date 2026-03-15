package com.memories.memories_recorder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.memories.memories_recorder.ui.navigation.NavGraph
import com.memories.memories_recorder.ui.navigation.Routes
import com.memories.memories_recorder.ui.theme.MemoriesRecorderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MemoriesRecorderTheme {
                AppNavigation() // NavGraph
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavGraph(
        navController = navController,
        startDestination = Routes.LOGIN
    )
}

