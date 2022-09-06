import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

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

    @Test
    fun m814() {
        val inputTree1 = Medium.TreeNode(0)

        val r1 = medium.m814(inputTree1)

        assertEquals(r1, null)

        val inputTree2 = Medium.TreeNode(1).apply {
            right = Medium.TreeNode(0).apply {
                left = Medium.TreeNode(0)
                right = Medium.TreeNode(1)
            }
        }

        val r2 = medium.m814(inputTree2)

        assertNotNull(r2?.right)
        assertNotNull(r2?.right?.right)
        assertNull(r2?.right?.left)
    }
}