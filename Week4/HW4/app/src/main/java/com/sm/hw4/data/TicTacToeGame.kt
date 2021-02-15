package com.sm.hw4.data

const val X = 'x'
const val O = 'o'
const val EMPTY = '_'


/* Our game is reusable across many places and independent from View layer */
class TicTacToeGame(
    val state: Array<CharArray> = Array(3) { CharArray(3) { EMPTY } }
) {

    var onGameEnd: ((GameEnd, Array<Pair<Int, Int>>?) -> Unit)? = null
        set(value) {
            field = value
            /* Callback game state when registered */
            checkGameEnd()
        }

    private var moveCount = state.sumOf { i -> i.count { c -> c != EMPTY } }
    var gameOver = moveCount == 9

    fun moveAt(i: Int, j:Int) {
        if (state[i][j] == EMPTY && !gameOver) {
            state[i][j] = if (isXTurn()) X else O
            moveCount++
            checkGameEnd()
        }
    }

    /* X always starts first, meaning if total moves count is even then its turn */
    fun isXTurn() = moveCount % 2 == 0

    private fun checkGameEnd() {
        gameOver = false
        for (i in 0..2) {
            /* Check rows if not found else columns */
            if (state[i][0] != EMPTY && state[i][0] == state[i][1] && state[i][1] == state[i][2]) {
                gameOver = true
                onGameEnd?.invoke(
                    if (state[i][0] == X) GameEnd.X_WON else GameEnd.O_WON,
                    arrayOf(Pair(i, 0), Pair(i, 1), Pair(i, 2)))
            } else if (state[0][i] != EMPTY && state[0][i] == state[1][i] && state[1][i] == state[2][i]) {
                gameOver = true
                onGameEnd?.invoke(
                    if (state[0][i] == X) GameEnd.X_WON else GameEnd.O_WON,
                    arrayOf(Pair(0, i), Pair(1, i), Pair(2, i)))
            }
        }

        /* Check diagonals */
        if (state[0][0] != EMPTY && state[0][0] == state[1][1] && state[1][1] == state[2][2]) {
            gameOver = true
            onGameEnd?.invoke(
                if (state[0][0] == X) GameEnd.X_WON else GameEnd.O_WON,
                arrayOf(Pair(0, 0), Pair(1, 1), Pair(2, 2)))
        } else if (state[0][2] != EMPTY && state[0][2] == state[1][1] && state[1][1] == state[2][0]) {
            gameOver = true
            onGameEnd?.invoke(
                if (state[0][2] == X) GameEnd.X_WON else GameEnd.O_WON,
                arrayOf(Pair(0, 2), Pair(1, 1), Pair(2, 0)))
        }

        /* All positions are filled and no winner */
        if (moveCount == 9 && !gameOver) {
            gameOver = true
            onGameEnd?.invoke(GameEnd.DRAW, null)
        }
    }
}

enum class GameEnd {
    X_WON,
    O_WON,
    DRAW
}