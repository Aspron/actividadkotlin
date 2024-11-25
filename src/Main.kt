
fun main() {

    for (x in 1..100) {

        when {

            x % 3 == 0 && x % 5 == 0 -> println("triqui")

            x % 3 == 0 -> println("tri")

            x % 5 == 0 -> println("qui")

            else -> println(x)

        }
    }
}
