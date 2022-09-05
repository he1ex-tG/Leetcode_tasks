
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
}