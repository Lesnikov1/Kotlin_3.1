fun main() {
    agoToText(3180)
}

fun agoToText(seconds: Int) {
    when (seconds) {
        in 0..60 -> println("был(а) только что")
        in 61..3600 -> println("был(а) ${variantForMinutes(seconds / 60)}")
        in 3601..86400 -> println("был(а) ${variantForHours(seconds / 3600)}")
        in 86401..172800 -> println("был(а) вчера")
        in 172801..259200 -> println("был(а) позавчера")
        else -> println("был(а) очень давно")
    }
}

fun variantForMinutes(minutes: Int): String {
    return when {
        minutes % 10 == 1 && minutes != 11 -> "$minutes минуту назад"
        minutes % 10 in 2..4 && (minutes !in 12 .. 14) -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun variantForHours(hours: Int): String {
    return when {
        hours == 1 || hours == 21 -> "$hours час назад"
        hours in 2..4 || hours in 22..24 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}