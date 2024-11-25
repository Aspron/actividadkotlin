fun main() {
    println("Escribe la primera palabra:")
    val palabra1 = readLine()?.trim() ?: ""
    println("Escribe la segunda palabra:")
    val palabra2 = readLine()?.trim() ?: ""

    val resultado = sonAnagramas(palabra1, palabra2)

    if (resultado) {
        println("Las palabras \"$palabra1\" y \"$palabra2\" son anagramas.")
    } else {
        println("Las palabras \"$palabra1\" y \"$palabra2\" no son anagramas.")
    }
}

fun sonAnagramas(palabra1: String, palabra2: String): Boolean {

    if (palabra1.equals(palabra2, ignoreCase = true)) {
        return false
    }

    val palabra1Ordenada = palabra1.lowercase().toCharArray().sorted()
    val palabra2Ordenada = palabra2.lowercase().toCharArray().sorted()

    return palabra1Ordenada == palabra2Ordenada
}
