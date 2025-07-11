package pl.edu.pja.kdudek.filmoteka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.edu.pja.kdudek.filmoteka.navigation.Router
import pl.edu.pja.kdudek.filmoteka.ui.components.AppBar
import pl.edu.pja.kdudek.filmoteka.ui.components.buttons.AddMovieButton
import pl.edu.pja.kdudek.filmoteka.ui.theme.FilmotekaTheme


@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FilmotekaTheme {
                val scrollBehavior =
                    TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        AppBar(
                            scrollBehavior = scrollBehavior,
                            currentRoute = currentRoute,
                            navController = navController
                        )
                    },
                    floatingActionButton = {
                        if (currentRoute == "film_list") {
                            AddMovieButton(navController)
                        }
                    }
                ) { innerPadding ->
                    Router(navController, innerPadding)
                }
            }
        }
    }
}
