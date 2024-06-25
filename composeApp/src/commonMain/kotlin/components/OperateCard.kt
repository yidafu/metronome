package components

import LocalRhythmViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import icons.AddCircle
import icons.MinusCircle
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun BeatPerMinute() {
    val vm = LocalRhythmViewModel.current
    val bpm = vm.bpm.collectAsState()
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Icon(MinusCircle, "increase bpm", Modifier.size(24.dp).clickable { vm.changeBpm(-1) })
        Spacer(Modifier.width(12.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("BPM", style = MaterialTheme.typography.labelSmall)
            Text(bpm.value.toString(), style = MaterialTheme.typography.titleLarge)
        }
        Spacer(Modifier.width(12.dp))

        Icon(AddCircle, "decrease bpm", Modifier.size(24.dp).clickable { vm.changeBpm(1) })
    }
}

@Composable
@Preview
fun OperateCard() {
    Column(
        Modifier
            .background(
                MaterialTheme.colorScheme.surfaceContainerLowest,
                RoundedCornerShape(16.dp),
            ).padding(32.dp, 16.dp)
            .fillMaxSize(),
    ) {
        BeatPerMinute()

        Knob()
    }
}
