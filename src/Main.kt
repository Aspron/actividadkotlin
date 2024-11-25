fun main() {
    println("Escribe la primera palabra:")
    val primerapalabra = readLine()?.trim() ?: ""
    println("Escribe la segunda palabra:")
    val segundapalabra = readLine()?.trim() ?: ""

    val resultado = Comprobacion(primerapalabra, segundapalabra)

    if (resultado) {
        println("Las palabras \"$primerapalabra\" y \"$segundapalabra\" son anagramas.")
    } else {
        println("Las palabras \"$primerapalabra\" y \"$segundapalabra\" no son anagramas.")
    }
}

fun Comprobacion(primerapalabra: String, segundapalabra: String): Boolean {

    if (primerapalabra.equals(segundapalabra, ignoreCase = true)) {
        return false
    }

    val palabra1Ordenada = primerapalabra.lowercase().toCharArray().sorted()
    val palabra2Ordenada = segundapalabra.lowercase().toCharArray().sorted()

    return palabra1Ordenada == palabra2Ordenada
}
