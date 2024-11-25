
fun main() {

    for (i in 1..100) {

        when {

            i % 3 == 0 && i % 5 == 0 -> println("triqui")

            i % 3 == 0 -> println("tri")

            i % 5 == 0 -> println("qui")

            else -> println(i)

        }
    }
}
