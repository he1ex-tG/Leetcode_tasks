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

    @Test
    fun m429() {
        val inputTree = Medium.Node(1).apply {
            children = listOf(
                Medium.Node(3).apply {
                    children = listOf(
                        Medium.Node(5),
                        Medium.Node(6)
                    )
                },
                Medium.Node(2),
                Medium.Node(4)
            )
        }

        val r1 = medium.m429(inputTree)

        assertEquals(r1.size, 3)
    }
}