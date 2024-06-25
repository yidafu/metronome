package components

import LocalRhythmViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.ajalt.colormath.extensions.android.composecolor.toColormathColor
import com.github.ajalt.colormath.extensions.android.composecolor.toComposeColor
import ext.darken
import viewmodel.SoundWeight

@Composable
fun Beat(
    weight: SoundWeight,
    onClick: (nextWeight: SoundWeight) -> Unit,
) {
    val bgColor = MaterialTheme.colorScheme.surfaceDim
    val cmColor = bgColor.toColormathColor()
    val barColor = cmColor.toHSL().darken(0.1).toComposeColor()
    val beatHeight = 150.dp
    Box {
        Column(
            Modifier
                .background(bgColor, shape = RoundedCornerShape(8.dp))
                .width(40.dp)
                .height(beatHeight)
                .clickable {
                    onClick(weight.next())
                },
        ) { }

        Column(
            Modifier
                .offset(y = beatHeight / 3 * (3 - weight.toInt()))
                .background(barColor, shape = RoundedCornerShape(8.dp))
                .height(beatHeight / 3 * weight.toInt())
                .width(40.dp),
        ) { }
    }
}

@Composable
fun Beats() {
    val vm = LocalRhythmViewModel.current

    val beats = vm.beats.collectAsState()
    Row(
        Modifier
            .padding(32.dp, 12.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        beats.value.forEachIndexed { i, b ->
            Beat(b) { next ->
                vm.updateWeight(i, next)
            }
        }
    }
}
