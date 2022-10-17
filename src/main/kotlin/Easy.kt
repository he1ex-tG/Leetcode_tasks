
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

    class ListNode(val `val`: Int) {
        var next: ListNode? = null
    }
    fun t234(head: ListNode?): Boolean {
        var p = head
        val arr = mutableListOf<Int>()
        while (p != null) {
            arr.add(p.`val`)
            p = p.next
        }
        for (i in 0 until arr.size / 2) {
            if (arr[i] != arr[arr.size - 1 - i]) {
                return false
            }
        }
        return true
    }

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun t235(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || p == null || q == null) {
            return null
        }
        val highval: Int
        val lowval: Int
        if (q.`val` > p.`val`) {
            lowval = p.`val`
            highval = q.`val`
        } else {
            lowval = q.`val`
            highval = p.`val`
        }
        var pointer = root!!
        while (pointer.`val` !in lowval..highval) {
            if (pointer.`val` < lowval) {
                pointer = pointer.right!!
            }
            if (pointer.`val` > highval) {
                pointer = pointer.left!!
            }
        }
        return pointer
    }

    fun t606(root: TreeNode?): String {
        return root?.let {
            var resultL = ""
            val l = t606(it.left)
            if (l.isNotEmpty()) {
                resultL = "(${l})"
            }
            var resultR = ""
            val r = t606(it.right)
            if (r.isNotEmpty()) {
                resultR = "(${r})"
            }
            if (resultR.isNotEmpty() && resultL.isEmpty()) {
                resultL = "(${resultL})"
            }
            "${it.`val`}${resultL}${resultR}"
        } ?: ""
    }

    fun t976(nums: IntArray): Int {
        val arrS = nums.sortedDescending()
        var resI = 0
        while (resI + 2 < nums.size) {
            if (arrS[resI] >= arrS[resI + 1] + arrS[resI + 2]) {
                ++resI
            } else {
                return arrS[resI] + arrS[resI + 1] + arrS[resI + 2]
            }
        }
        return 0
    }

    fun t1832(sentence: String): Boolean {
        //return  sentence.toSet().size == 26
        val res = IntArray(26).apply { fill(0) }
        sentence.forEach {
            ++res[it.toByte() - 'a'.toByte()]
        }
        res.forEach {
            if (it == 0) {
                return false
            }
        }
        return true
    }
}