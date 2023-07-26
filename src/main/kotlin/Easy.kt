import kotlin.math.max

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

    fun t1480(nums: IntArray): IntArray {
        var z = 0
        return nums.map {
            z += it
            z
        }.toIntArray()
    }

    fun t1672(accounts: Array<IntArray>): Int {
        return accounts.fold(0) { acc, ints ->
            max(acc, ints.sum())
        }
    }

    fun t412(n: Int): List<String> {
        val res = mutableListOf<String>()
        for (i in 1..n) {
            var tmpStr = ""
            if (i % 3 == 0) {
                tmpStr = "Fizz"
            }
            if (i % 5 == 0) {
                tmpStr += "Buzz"
            }
            if (tmpStr.isEmpty()) {
                tmpStr = i.toString()
            }
            res.add(tmpStr)
        }
        return res
    }

    fun t1342(num: Int): Int {
        var reducedNum = num
        var steps = 0
        while (reducedNum != 0) {
            when (reducedNum % 2) {
                0 -> reducedNum /= 2
                else -> reducedNum -= 1
            }
            ++steps
        }
        return steps
    }

    fun t876(head: ListNode?): ListNode? {
        var currentNode = head
        var listLength = 0
        while (currentNode != null) {
            currentNode = currentNode.next
            ++listLength
        }
        var middleNode = listLength / 2 + 1
        currentNode = head
        while (--middleNode != 0) {
            currentNode = currentNode?.next
        }
        return currentNode
    }

    fun t383(ransomNote: String, magazine: String): Boolean {
        val hashM = magazine.fold(hashMapOf<Char, Int>()) { acc, c ->
            acc.apply {
                put(c, getOrDefault(c, 0) + 1)
            }
        }
        ransomNote.forEach {
            if (hashM.getOrDefault(it, 0) > 0) {
                hashM[it] = hashM[it]!! - 1
            } else {
                return false
            }
        }
        return true
    }

    fun t88(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var pSize = m + n
        var pm = m - 1
        var pn = n - 1
        while (--pSize >= 0) {
            if (pm >= 0) {
                if (pn >= 0) {
                    if (nums1[pm] > nums2[pn]) {
                        nums1[pSize] = nums1[pm]
                        --pm
                    } else {
                        nums1[pSize] = nums2[pn]
                        --pn
                    }
                } else {
                    nums1[pSize] = nums1[pm]
                    --pm
                }
            } else {
                nums1[pSize] = nums2[pn]
                --pn
            }
        }
    }

    fun t27(nums: IntArray, `val`: Int): Int {
        var currentPos = 0
        var currentPointer = 0
        while (currentPointer < nums.size) {
            nums[currentPos] = nums[currentPointer]
            if (nums[currentPos] != `val`) {
                ++currentPos
            }
            ++currentPointer
        }
        return currentPos
    }

    fun t26(nums: IntArray): Int {
        var index = 0
        for (i in 1 until nums.size) {
            if (nums[index] != nums[i]) {
                index++
                nums[index] = nums[i]
            }
        }
        return index + 1
    }
}












