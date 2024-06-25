import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import theme.AppTypography
import theme.darkScheme
import theme.lightScheme
import viewmodel.RhythmViewModel

enum class MetronomeRoutes {
    Home,
    Setting,
}

val LocalNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

@Composable
@Preview
fun App() {
    val navController: NavHostController = rememberNavController()
    val darkTheme = false
    val colorScheme = when {
        darkTheme -> darkScheme
        else -> lightScheme
    }
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
        ) {

            CompositionLocalProvider(LocalNavController provides navController) {
                NavHost(
                    navController,
                    MetronomeRoutes.Home.name,
                    Modifier,
                ) {

                    composable(MetronomeRoutes.Home.name) {
                        HomeScreen()
                    }
                    composable(MetronomeRoutes.Setting.name) {
                        SettingScreen()
                    }
                }
            }

    }


}