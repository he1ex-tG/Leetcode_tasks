import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MediumTest {

    private val medium = Medium()

    @Test
    fun f1338() {
        val r1 = medium.t1338(intArrayOf(3,3,3,3,5,5,5,2,2,7))
        assertEquals(r1, 2)

        val r2 = medium.t1338(intArrayOf(7,7,7,7,7,7))
        assertEquals(r2, 1)
    }
}