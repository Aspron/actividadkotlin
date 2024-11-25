fun main() {
    val expresiones = listOf(
        "{a + b [c] * (2x2)}}}}",
        "{ [ a * ( c + d ) ] - 5 }",
        "{ a * ( c + d ) ] - 5 }",
        "{a^4 + (((ax4)}",
        "{ ] a * ( c + d ) + ( 2 - 3 )[ - 5 }",
        "{{{{{{(}}}}}}",
        "(a"
    )
    for (expresion in expresiones) {
        if (Balance(expresion)) {
            println("La expresión \"$expresion\" está balanceada.")
        } else {
            println("La expresión \"$expresion\" no está balanceada.")
        }
    }
}
fun Balance(expresion: String): Boolean {
    var contador = 0
    for (caracter in expresion) {
        when (caracter) {
            '{', '[', '(' -> contador++
            '}', ']', ')' -> contador--
        }

        if (contador < 0) {
            return false
        }
    }

    return contador == 0
}
