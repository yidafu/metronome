package components

import LocalNavController
import MetronomeRoutes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppHeader() {
    Row(
        Modifier
            .padding(horizontal = 12.dp)
            .height(32.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
        Box {}
        Text("Metronome")
        Row {
            val navCtrl = LocalNavController.current
            Icon(Icons.Default.Settings, "Setting", Modifier.size(20.dp).clickable {
                navCtrl.navigate(MetronomeRoutes.Setting.name)
            })
        }
    }
}

