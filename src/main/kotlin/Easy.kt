
class Easy {

    fun t387(s: String): Int {
        return s.foldIndexed(mutableMapOf<Char, Int>()) { i, acc, c ->
            acc[c] = when(acc[c]) {
                null -> i
                else -> -1
            }
            acc
        }.asSequence().firstOrNull { it.value != -1 }?.value ?: -1
    }

    fun t804(words: Array<String>): Int {
        /*
        val morzeABC = listOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
        val abc = ('a'..'z').toList()

        return words.map { w ->
            w.map { c ->
                morzeABC[abc.indexOf(c)]
            }.joinToString(separator = "")
        }.toSet().size
        */
        val hm = hashMapOf(
            'a' to ".-", 'b' to "-...", 'c' to "-.-.", 'd' to "-..", 'e' to ".", 'f' to "..-.", 'g' to "--.",
            'h' to "....", 'i' to "..", 'j' to ".---", 'k' to "-.-", 'l' to ".-..", 'm' to "--", 'n' to "-.",
            'o' to "---", 'p' to ".--.", 'q' to "--.-", 'r' to ".-.", 's' to "...", 't' to "-", 'u' to "..-",
            'v' to "...-", 'w' to ".--", 'x' to "-..-", 'y' to "-.--", 'z' to "--.."
        )
        return words.map { w ->
            w.map { c ->
                hm[c]
            }.joinToString(separator = "")
        }.toSet().size
    }
}