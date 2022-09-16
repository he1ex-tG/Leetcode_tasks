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

    fun t393(data: IntArray): Boolean {
        var nNext = 0
        for (i in data) {
            val bInt = Integer.toBinaryString(i).padStart(Byte.SIZE_BITS, '0')
            when (nNext) {
                0 -> {
                    for (k in bInt) {
                        if (k != '0') {
                            ++nNext
                        } else {
                            break
                        }
                    }
                    if (nNext == 1 || nNext > 4) {
                        return false
                    }
                }
                else -> {
                    if (bInt[0] != '1' || bInt[1] != '0') {
                        return false
                    }
                }
            }
            if (nNext > 0) {
                --nNext
            }
        }
        if (nNext > 0) {
            return false
        }
        return true
    }

    fun t1457(root: TreeNode?): Int {
        var count = 0

        fun preorder(node: TreeNode?, path: Int) {
            var path = path
            if (node != null) {
                // compute occurences of each digit
                // in the corresponding register
                path = path xor (1 shl node.`val`)
                // if it's a leaf check if the path is pseudo-palindromic
                if (node.left == null && node.right == null) {
                    // check if at most one digit has an odd frequency
                    if (path and path - 1 == 0) {
                        ++count
                    }
                }
                preorder(node.left, path)
                preorder(node.right, path)
            }
        }
        preorder(root, 0)
        return count
    }

    fun t1770(nums: IntArray, multipliers: IntArray): Int {
        fun dp(memo: Array<Array<Int?>>, nums: IntArray, multipliers: IntArray, op: Int, left: Int): Int {
            // For Right Pointer
            val n = nums.size
            if (op == multipliers.size) {
                return 0
            }

            // If already computed, return
            if (memo[op][left] != null) {
                return memo[op][left]!!
            }
            val l = nums[left] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left + 1)
            val r = nums[n - 1 - (op - left)] * multipliers[op] + dp(memo, nums, multipliers, op + 1, left)
            return Math.max(l, r).also { memo[op][left] = it }
        }
        val memo = Array(nums.size + 1) {
            arrayOfNulls<Int>(
                multipliers.size + 1
            )
        }
        // Zero operation done in the beginning
        return dp(memo, nums, multipliers, 0, 0)
    }
}