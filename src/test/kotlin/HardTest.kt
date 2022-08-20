import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HardTest {

    private val hard = Hard()

    @Test
    fun t871() {
        val v1 = hard.t871(target = 1, startFuel = 1, stations = arrayOf())
        assertEquals(v1, 0)

        val v2 = hard.t871(target = 100, startFuel = 1, stations = arrayOf(intArrayOf(10, 100)))
        assertEquals(v2, -1)

        val v3 = hard.t871(
            target = 100,
            startFuel = 10,
            stations = arrayOf(
                intArrayOf(10,60),
                intArrayOf(20,30),
                intArrayOf(30,30),
                intArrayOf(60,40)
            )
        )
        assertEquals(v3, 2)

        /*val v4 = hard.t871(
            target = 1000,
            startFuel = 299,
            stations = arrayOf(
                intArrayOf(13,21),
                intArrayOf(26,115),
                intArrayOf(100,47),
                intArrayOf(225,99),
                intArrayOf(299,141),
                intArrayOf(444,198),
                intArrayOf(608,190),
                intArrayOf(636,157),
                intArrayOf(647,255),
                intArrayOf(841,123)
            )
        )
        assertEquals(v4, 4)*/
    }
}