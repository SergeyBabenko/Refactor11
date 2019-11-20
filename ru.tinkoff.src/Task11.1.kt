fun main() {
    val input = readLine()
    val stack = mutableListOf<Char>()
    val indexStack = mutableListOf<Int>()
    val leftBraces = listOf('(', '[', '{')
    val rightBraces = listOf(')', ']', '}')
    var errorPosition = -1
    if (input != null) {
        for (i in input.indices) {
            if (errorPosition < 0) {
                if (input[i] in leftBraces) {
                    stack.add(input[i])
                    indexStack.add(i + 1)
                } else if (input[i] in rightBraces)
                    if (stack.isEmpty()) {
                        errorPosition = i
                    } else {
                        indexStack.removeAt(indexStack.lastIndex)
                        when (input[i]) {
                            ')' -> if (stack.last() == '(') stack.removeAt(stack.lastIndex) else errorPosition = i
                            '}' -> if (stack.last() == '{') stack.removeAt(stack.lastIndex) else errorPosition = i
                            ']' -> if (stack.last() == '[') stack.removeAt(stack.lastIndex) else errorPosition = i
                        }
                    }
            }
        }
        when {
            errorPosition >= 0 -> println(errorPosition + 1)
            stack.isNotEmpty() -> print(indexStack.last())
            else -> println("Success")
        }
    }
}