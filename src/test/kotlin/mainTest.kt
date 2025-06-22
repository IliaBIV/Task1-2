import org.junit.Assert.*
import org.junit.Test

class mainTest {

    @Test
    fun testcomission1() {
        val card = "Mastercard"
        val amount = 150_000
        val totalAmount = 0

        val result = comission(cardType = card, amount = amount, totalAmount = totalAmount)
        assertEquals(470, result)

    }

    @Test
    fun testcomission2() {
        val card = "Mastercard"
        val amount = 50_000
        val totalAmount = 50_000

        val result = comission(cardType = card, amount = amount, totalAmount = totalAmount)
        assertEquals(170, result)
    }

    @Test
    fun testWrongCard() {
        val card = "fghfgh"
        val amount = 150_000
        val totalAmount = 0

        val result = comission(cardType = card, amount = amount, totalAmount = totalAmount)
        assertEquals(ERROR2, result)

    }

    @Test
    fun testLimitAmount() {
        val card = "Visa"
        val amount = 500_000
        val totalAmount = 0
        val result = comission(cardType = card, amount = amount, totalAmount = totalAmount)
        assertEquals(ERROR, result)
    }

    @Test
    fun testLimitTotalAmount() {
        val card = "Visa"
        val amount = 0
        val totalAmount = 700_000
        val result = comission(cardType = card, amount = amount, totalAmount = totalAmount)
        assertEquals(ERROR, result)
    }

    @Test
    fun testLimitAmountVKPAY() {
        val card = "VK PAY"
        val amount = 15001
        val totalAmount = 0
        val result = comission(cardType = card, amount = amount, totalAmount = totalAmount)
        assertEquals(100, result)
    }

    @Test
    fun testLimitTotalAmountVKPAY() {
        val card = "VK PAY"
        val amount = 0
        val totalAmount = 40001
        val result = comission(cardType = card, amount = amount, totalAmount = totalAmount)
        assertEquals(ERROR, result)
    }

    @Test
    fun noCommissionTest1() {
        val card = "Mastercard"
        val amount = 7500
        val totalAmount = 0
        val result = comission(cardType = card, amount = amount, totalAmount = totalAmount)
        assertEquals(10, result)
    }

    @Test
    fun noCommissionTest2() {
        val card = "Maestro"
        val amount = 50000
        val totalAmount = 0
        val result = comission(cardType = card, amount = amount, totalAmount = totalAmount)
        assertEquals(0, result)
    }

    @Test
    fun noCommissionTest3() {
        val card = "VK PAY"
        val amount = 14000
        val totalAmount = 0
        val result = comission(cardType = card, amount = amount, totalAmount = totalAmount)
        assertEquals(0, result)
    }


}
