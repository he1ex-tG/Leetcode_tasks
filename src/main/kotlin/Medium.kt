
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
}