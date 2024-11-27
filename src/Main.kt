fun main() {
    val Ejemplos = listOf(
        arrayOf(
            arrayOf("X", "O", "X"),
            arrayOf("O", "X", "O"),
            arrayOf("O", "O", "X")
        ), arrayOf(
            arrayOf("", "O", "X"),
            arrayOf("", "X", "O"),
            arrayOf("", "O", "X")
        ), arrayOf(
            arrayOf("O", "O", "O"),
            arrayOf("O", "X", "X"),
            arrayOf("O", "X", "X")),
        arrayOf(
            arrayOf("X", "O", "X"),
            arrayOf("X", "X", "O"),
            arrayOf("X", "X", "X")
        )
    )

    Ejemplos.forEach { board ->
        println(checkBoard(board))
    }
}

fun checkBoard(ejemplo: Array<Array<String>>): String {

    var contadorx = 0
    var contadoro = 0

    ejemplo.forEach { row ->
        if (row.size != 3) return "Nulo"
        row.forEach { cell ->
            when (cell) {
                "X" -> contadorx++
                "O" -> contadoro++
                "" -> {}
                else -> return "Nulo"
            }
        }
    }

    if (ejemplo.size != 3 || kotlin.math.abs(contadorx - contadoro) > 1) return "Nulo"

    val winningCombos = listOf(
        listOf(0, 1, 2),
        listOf(3, 4, 5),
        listOf(6, 7, 8),
        listOf(0, 3, 6),
        listOf(1, 4, 7),
        listOf(2, 5, 8),
        listOf(0, 4, 8),
        listOf(2, 4, 6)
    )

    val flatBoard = ejemplo.flatten()

    var xgana = false
    var ogana = false

    for (combo in winningCombos) {
        val (a, b, c) = combo
        if (flatBoard[a] == "X" && flatBoard[a] == flatBoard[b] && flatBoard[a] == flatBoard[c]) {
            xgana = true
        }
        if (flatBoard[a] == "O" && flatBoard[a] == flatBoard[b] && flatBoard[a] == flatBoard[c]) {
            ogana = true
        }
    }

    if (xgana && ogana) return "Nulo"
    if (xgana) return "X"
    if (ogana) return "O"

    return if (flatBoard.contains("")) "Empate" else "Empate"
}
