package viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RhythmViewModel : ViewModel() {
    val beetPerMinute = MutableStateFlow(60)
    val beatsFlow = MutableStateFlow(List(4) { SoundWeight.Week })
    val degreeFlow = MutableStateFlow(0.0)

    val playingFlow = MutableStateFlow(false)

    val beats = beatsFlow.asStateFlow()

    val bpm = beetPerMinute.asStateFlow()

    val status = playingFlow.asStateFlow()

    fun updateWeight(
        index: Int,
        weight: SoundWeight,
    ) {
        beatsFlow.update { list ->
            list
                .mapIndexed { i, v ->
                    if (i == index) weight else v
                }.toList()
        }
    }

    /**
     * 最少 20 bpm,最多 240 bpm
     */
    fun changeBpm(step: Int = 1) {
        beetPerMinute.update {
            if (it + step in 20..240) {
                it + step
            } else {
                it
            }
        }
    }

    fun updateBpmByDegree(degree: Double) {
        val nextDegree = degreeFlow.value + degree
        val increaseBpm = (nextDegree / 12).toInt()
        this.changeBpm(increaseBpm)

        degreeFlow.update {
            nextDegree % 12
        }
    }

    fun toggle() {
        playingFlow.update { !it }
    }

}
