fun main() {

    val acciones = listOf(
        listOf("correr", "saltar", "correr", "saltar", "correr") to "_|_|_",
        listOf("correr", "correr", "correr", "saltar", "correr") to "_|_|_",
        listOf("correr", "correr", "saltar", "saltar", "correr") to "_|_|_",
        listOf("correr", "correr", "saltar", "saltar", "correr") to "_|_|_|_",
        listOf("correr", "saltar", "correr", "saltar") to "_|_|_",
        listOf("correr", "saltar", "correr", "saltar", "correr", "saltar", "correr") to "_|_|_",
        listOf("saltar", "saltar", "saltar", "saltar", "saltar") to "|||||",
        listOf("saltar", "saltar", "saltar", "saltar", "saltar") to "||_||"
    )

    for ((accionesAtleta, pista) in acciones) {
        val resultado = evaluarCarrera(accionesAtleta, pista)
        println("Acciones: $accionesAtleta, Pista inicial: \"$pista\", Resultado: ${resultado.second}, Superada: ${resultado.first}")
    }
}

fun evaluarCarrera(acciones: List<String>, pista: String): Pair<Boolean, String> {

    if (acciones.size != pista.length) {
        return false to "La longitud de acciones y pista no coinciden"
    }

    val pistaFinal = StringBuilder(pista)
    var carreraCorrecta = true

    for (i in acciones.indices) {
        val accion = acciones[i]
        val tramo = pista[i]

        when {
            accion == "correr" && tramo == '_' -> pistaFinal[i] = '_'
            accion == "saltar" && tramo == '|' -> pistaFinal[i] = '|'
            accion == "saltar" && tramo == '_' -> {
                pistaFinal[i] = 'x'
                carreraCorrecta = false
            }
            accion == "correr" && tramo == '|' -> {
                pistaFinal[i] = '/'
                carreraCorrecta = false
            }
            else -> {
                pistaFinal[i] = '?'
                carreraCorrecta = false
            }
        }
    }
    return carreraCorrecta to pistaFinal.toString()
}
