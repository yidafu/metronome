package viewmodel

enum class SoundWeight {
    None,
    Week,
    Sub,
    Strong;

    fun next(): SoundWeight {
        return when(this) {
            None -> Week
            Week -> Sub
            Sub -> Strong
            Strong -> None
        }
    }

    fun toInt(): Int {
        return this.ordinal
    }
}