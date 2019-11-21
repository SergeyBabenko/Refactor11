private val stack = mutableListOf<Char>()
private val indexStack = mutableListOf<Int>()
fun handleBraces(input: String, leftBraces: List<Char>, rightBraces: List<Char>) {
    val errorPosition = getErrorPosition(leftBraces, rightBraces, input)
    when {
        errorPosition >= 0 -> println(errorPosition + 1)
        stack.isNotEmpty() -> print(indexStack.last())
        else -> println("Success")
    }
}

private fun getErrorPosition(leftBraces: List<Char>, rightBraces: List<Char>, input: String): Int {
    for (i in input.indices) {
        if (input[i] in leftBraces) {
            stack.add(input[i])
            indexStack.add(i + 1)
        } else if (input[i] in rightBraces)
            if (stack.isEmpty()) {
                return i
            } else {
                indexStack.removeAt(indexStack.lastIndex)
                when (input[i]) {
                    rightBraces[0] -> if (stack.last() == leftBraces[0]) stack.removeAt(stack.lastIndex) else return i
                    rightBraces[1] -> if (stack.last() == leftBraces[1]) stack.removeAt(stack.lastIndex) else return i
                    rightBraces[2] -> if (stack.last() == leftBraces[2]) stack.removeAt(stack.lastIndex) else return i
                }
            }
    }
    return -1
}