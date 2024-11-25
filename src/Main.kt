fun main() {
    println("Introduce la primera palabra:")
    val palabra1 = readLine()?.trim() ?: ""
    println("Introduce la segunda palabra:")
    val palabra2 = readLine()?.trim() ?: ""

    // Verificar si son anagramas
    if (sonAnagramas(palabra1, palabra2)) {
        println("Las palabras \"$palabra1\" y \"$palabra2\" son anagramas.")
    } else {
        println("Las palabras \"$palabra1\" y \"$palabra2\" no son anagramas.")
    }
}

fun sonAnagramas(palabra1: String, palabra2: String): Boolean {

    if (palabra1.equals(palabra2, ignoreCase = true)) return false

    return palabra1.lowercase().toCharArray().sorted() == palabra2.lowercase().toCharArray().sorted()
}
