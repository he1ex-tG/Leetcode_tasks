class Hard {

    fun t871(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val N = stations.size
        val dp = IntArray(N+1) { 0 }
        dp[0] = startFuel

        for (i in 0 until N) {
            for (t in i downTo 0) {
                if (dp[t] >= stations[i][0]) {
                    dp[t+1] = Math.max(
                        dp[t+1],
                        dp[t] + stations[i][1]
                    )
                }
            }
        }
        for (i in 0..N) {
            if (dp[i] >= target) {
                return i
            }
        }
        return -1
    }
}