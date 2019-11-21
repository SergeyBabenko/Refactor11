fun main() {
    val leftBraces = listOf('(', '[', '{')
    val rightBraces = listOf(')', ']', '}')
    val input = readLine()
    if (input != null) {
        handleBraces(input, leftBraces, rightBraces)
    }
}
