
class Medium {

    fun t1338(arr: IntArray): Int {
        val list: List<Int> = arr.fold(hashMapOf<Int, Int>()) { acc, i ->
            acc[i] = acc[i]?.plus(1) ?: 1
            acc
        }.values.sorted()
        val target = arr.size / 2
        var acc = 0
        for (i in list.size - 1 downTo 0) {
            acc += list[i]
            if (acc >= target) {
                return list.size - i
            }
        }
        return list.size
    }

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }
    fun m429(root: Node?): List<List<Int>> {
        fun recurrent(node: Node?, resultList: MutableList<MutableList<Int>>, depth: Int = 0) {
            if (node == null) {
                return
            }
            if (resultList.size == depth) {
                resultList.add(mutableListOf())
            }
            resultList[depth].add(node.`val`)
            for (childrenNode in node.children) {
                recurrent(childrenNode, resultList, depth + 1)
            }
        }

        val resultMutableList: MutableList<MutableList<Int>> = mutableListOf()
        recurrent(root, resultMutableList)
        val resultList = resultMutableList.map {
            it.toList()
        }.toList()
        return resultList
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun m814(root: TreeNode?): TreeNode? {
        fun recurrentCheck(node: TreeNode?): TreeNode? {
            if (node == null) {
                return null
            }
            node.left = recurrentCheck(node.left)
            node.right = recurrentCheck(node.right)
            return if (node.left == null && node.right == null && (node.`val` != 1)) {
                null
            } else {
                node
            }
        }
        return recurrentCheck(root)
    }

    fun t948(tokens: IntArray, power: Int): Int {
        val sTokens = tokens.sorted()
        var result = 0
        var currentPower = power
        var i = 0
        var z = tokens.size - 1
        while (i <= z) {
            if (currentPower >= sTokens[i]) {
                currentPower -= sTokens[i]
                ++result
                ++i
            } else {
                if (result == 0) {
                    return 0
                }
                if (i == z) {
                    return result
                }
                currentPower += sTokens[z]
                if (currentPower < sTokens[i]) {
                    return result
                }
                --result
                --z
            }
        }
        return result
    }
}