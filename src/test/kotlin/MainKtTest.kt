import org.junit.Assert.*
import org.junit.Test

class MainKtTest {
    @Test
    fun calculateCommissionMir() {
        val transfer = 100_000
        val typeCard = "Mir"

        val result = calculateCommission(typeCard, transfer)
        assertEquals(0.0, result)
    }

    @Test
    fun calculateCommissionVisa1() {
        val transfer = 100_000
        val typeCard = "Visa"

        val result = calculateCommission(typeCard, transfer)
        assertEquals(750.0, result)
    }

    @Test
    fun calculateCommissionVisa2() {
        val transfer = 3_000
        val typeCard = "Visa"

        val result = calculateCommission(typeCard, transfer)
        assertEquals(35.0, result)
    }

    @Test
    fun calculateCommissionMC1() {
        val transfer = 3_000
        val typeCard = "MasterCard"

        val result = calculateCommission(typeCard, transfer)
        assertEquals(0.0, result)
    }

    @Test
    fun calculateCommissionMC3() {
        val transfer = 100_000
        val typeCard = "MasterCard"

        val result = calculateCommission(typeCard, transfer)
        assertEquals(620.0, result)
    }

    @Test
    fun calculateCommissionCardType() {
        val transfer = 100_000
        val typeCard = "AlfaBank"

        val result = calculateCommission(typeCard, transfer)
        assertEquals("Введен неверный тип карты", result)
    }

    @Test
    fun commissionDayLimit() {
        val transfer = 200_000
        val typeCard = "MasterCard"

        val result = commission(typeCard, transfer)
        assertEquals("Превышен лимит переводов за день, перевод не выполнен", result)
    }

    @Test
    fun commissionMonthLimit() {
        val transfer = 100_000
        val typeCard = "MasterCard"
        val sumTransfer = 550_000

        val result = commission(typeCard, transfer, sumTransfer)
        assertEquals("Превышен лимит переводов за месяц, перевод не выполнен", result)
    }

    @Test
    fun commission() {
        val transfer = 100_000
        val typeCard = "Visa"
        val sumTransfer = 10_000

        val result = commission(typeCard, transfer, sumTransfer)
        assertEquals("Комиссия за перевод 100000 руб. по карте Visa составит 750.0", result)
    }
}