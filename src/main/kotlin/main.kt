import kotlin.math.max

const val ERROR = -404
const val ERROR2 = -1000


fun main() {


    println(comission("Mastercard", 50000, 50000))

}


fun comission(cardType: String, amount: Int, totalAmount: Int): Int {
    if ((amount > 150000 || (amount + totalAmount) > 600000) ||
        cardType == "VK PAY" && (amount > 15000 || amount + totalAmount > 40000)
    ) return ERROR

    return when (cardType) {
        "Visa", "Мир" -> max((amount * 0.0075).toInt(), 35)
        "Mastercard", "Maestro" -> if ((amount + totalAmount) in 300..75000) {
            return 0
        } else if (totalAmount >= 75000) {
            return ((amount * 0.006).toInt()) + 20
        } else {
            return (((amount + totalAmount) - 75000) * 0.006).toInt() + 20
        }

        "VK PAY" -> 0

        else -> ERROR2
    }
}