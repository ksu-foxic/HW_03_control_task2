import kotlin.math.max

fun main() {
    println(commission("Mir", 50_000, 0))
    println(commission("Mir", 200_000, 0))
    println(commission("Mir", 50_000, 590000))
    println(commission("Visa", 5_000, 0))
    println(commission("Visa", 50_000, 0))
    println(commission("MasterCard", 50_000, 0))
    println(commission("MasterCard", 100_000, 0))
}

fun commission(typeCard: String = "Mir", transfer: Int, sumTransfer: Int = 0): Any {

    val limitDay: Double = 150_000.0
    val limitMounth: Double = 600_000.0

    if (transfer > limitDay) return "Превышен лимит переводов за день, перевод не выполнен"
    if ((transfer + sumTransfer) > limitMounth) return "Превышен лимит переводов за месяц, перевод не выполнен"

    val commission = calculateCommission(typeCard, transfer)
    return "Комиссия за перевод $transfer руб. по карте $typeCard составит $commission"
}

fun calculateCommission(typeCard: String, transfer: Int) = when (typeCard) {
    "Mir" -> 0.0
    "Visa" -> max(35.0, transfer * 0.0075)
    "MasterCard" -> {
        if (transfer < 75_000) {
            0.0
        } else transfer * 0.006 + 20
    }
    else -> "Введен неверный тип карты"
}