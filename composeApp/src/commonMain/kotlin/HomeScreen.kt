import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import components.AppHeader
import components.Beats
import components.OperateCard
import org.jetbrains.compose.ui.tooling.preview.Preview
import viewmodel.RhythmViewModel

val LocalRhythmViewModel =
    compositionLocalOf<RhythmViewModel> {
        error("No LocalRhythmViewModel provided")
    }

@Composable
@Preview
fun HomeScreen() {
    val vm = remember { RhythmViewModel() }
    CompositionLocalProvider(LocalRhythmViewModel provides vm) {
        Column(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface)) {
            AppHeader()
            Beats()
            OperateCard()
        }
    }
}
