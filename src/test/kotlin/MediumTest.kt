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

    @Test
    fun t948() {
        val r1 = medium.t948(intArrayOf(100), 50)

        assertEquals(r1, 0)

        val r2 = medium.t948(intArrayOf(100, 200), 150)

        assertEquals(r2, 1)

        val r3 = medium.t948(intArrayOf(100, 200, 300, 400), 200)

        assertEquals(r3, 2)

        val r4 = medium.t948(intArrayOf(81, 91, 31), 73)

        assertEquals(r4, 1)
    }

    @Test
    fun t393() {
        val r1 = medium.t393(intArrayOf(197, 130, 1))

        assertEquals(r1, true)

        val r2 = medium.t393(intArrayOf(235,140,4))

        assertEquals(r2, false)

        val r3 = medium.t393(intArrayOf(255))

        assertEquals(r3, false)

        val r4 = medium.t393(intArrayOf(237))

        assertEquals(r4, false)

        val r5 = medium.t393(intArrayOf(228,189,160,229,165,189,13,10))

        assertEquals(r5, true)
    }

    @Test
    fun t1457() {
        val inputTree1 = Medium.TreeNode(2).apply {
            left = Medium.TreeNode(3).apply {
                left = Medium.TreeNode(3)
                right = Medium.TreeNode(1)
            }
            right = Medium.TreeNode(1).apply {
                right = Medium.TreeNode(1)
            }
        }

        val r1 = medium.t1457(inputTree1)

        assertEquals(r1, 2)
    }

    @Test
    fun t1770() {
        val r1 = medium.t1770(intArrayOf(1,2,3), intArrayOf(3,2,1))

        assertEquals(r1, 14)

        val r2 = medium.t1770(intArrayOf(-5,-3,-3,-2,7,1), intArrayOf(-10,-5,3,4,6))

        assertEquals(r2, 102)
    }

    @Test
    fun t718() {
        val r1 = medium.t718(intArrayOf(1,2,3,2,1), intArrayOf(3,2,1,4,7))

        assertEquals(r1, 3)

        val r2 = medium.t718(intArrayOf(0,0,0,0,0), intArrayOf(0,0,0,0,0))

        assertEquals(r2, 5)

        val r3 = medium.t718(intArrayOf(0,0,0,0,0,0,1,0,0,0), intArrayOf(0,0,0,0,0,0,0,1,0,0))

        assertEquals(r3, 9)
    }

    @Test
    fun t237() {
        val head = Medium.ListNode(4).apply {
            next = Medium.ListNode(5).apply {
                next = Medium.ListNode(1).apply {
                    next = Medium.ListNode(9)
                }
            }
        }

        val res1 = medium.t237(head.next)

        assertEquals(head.next?.next?.`val`, 9)
    }

    @Test
    fun t80() {
        val res1 = medium.t80(intArrayOf(0,0,1,1,1,1,2,3,3))
        assertEquals(res1, 7)
    }

    @Test
    fun t189() {
        val res1 = medium.t189(intArrayOf(1,2,3,4,5,6,7), 3)
        assertEquals(res1, Unit)

        val res2 = medium.t189(intArrayOf(-1), 2)
        assertEquals(res2, Unit)
    }

    @Test
    fun t55() {
        val res1 = medium.t55(intArrayOf(2,3,1,1,4))
        assertEquals(res1, true)

        val res2 = medium.t55(intArrayOf(3,2,1,0,4))
        assertEquals(res2, false)
    }

    @Test
    fun t45() {
        val res1 = medium.t45(intArrayOf(2,3,1,1,4))
        assertEquals(res1, 2)

        val res2 = medium.t45(intArrayOf(2,3,0,1,4))
        assertEquals(res2, 2)
    }
}