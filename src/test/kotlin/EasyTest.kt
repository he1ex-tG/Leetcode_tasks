import com.sun.source.tree.Tree
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class EasyTest() {

    private val easy = Easy()

    @Test
    fun t387() {
        val t1 = easy.t387("leetcode")
        assertEquals(t1, 0)

        val t2 = easy.t387("loveleetcode")
        assertEquals(t2, 2)

        val t3 = easy.t387("aabb")
        assertEquals(t3, -1)
    }

    @Test
    fun t804() {
        val arr1 = easy.t804(arrayOf("gin","zen","gig","msg"))
        assertEquals(arr1, 2)

        val arr2 = easy.t804(arrayOf("a"))
        assertEquals(arr2, 1)
    }

    @Test
    fun t234() {
        val head = Easy.ListNode(1)
        head.next = Easy.ListNode(2)

        val res1 = easy.t234(head)
        assertEquals(res1, false)
    }

    @Test
    fun t235() {
        val root = Easy.TreeNode(6).apply {
            left = Easy.TreeNode(2).apply {
                left = Easy.TreeNode(0)
                right = Easy.TreeNode(4).apply {
                    left = Easy.TreeNode(3)
                    right = Easy.TreeNode(5)
                }
            }
            right = Easy.TreeNode(8).apply {
                left = Easy.TreeNode(7)
                right = Easy.TreeNode(9)
            }
        }
        val p1 = root.left
        val q1 = root.right
        val res1 = easy.t235(root, p1, q1)
        assertEquals(res1?.`val`, 6)

        val p2 = root.left?.left
        val q2 = root.left?.right?.left
        val res2 = easy.t235(root, p2, q2)
        assertEquals(res2?.`val`, 2)

        val p3 = root
        val q3 = root.right?.right
        val res3 = easy.t235(root, p3, q3)
        assertEquals(res3?.`val`, 6)

        val root2 = Easy.TreeNode(2).apply {
            left = Easy.TreeNode(1)
            right = Easy.TreeNode(3)
        }
        val p4 = root2.right
        val q4 = root2.left
        val res4 = easy.t235(root2, p4, q4)
        assertEquals(res4?.`val`, 2)
    }

    @Test
    fun t606() {
        val root1 = Easy.TreeNode(1).apply {
            left = Easy.TreeNode(2).apply {
                left = Easy.TreeNode(4)
            }
            right = Easy.TreeNode(3)
        }

        val res1 = easy.t606(root1)

        assertEquals(res1, "1(2(4))(3)")

        val root2 = Easy.TreeNode(1).apply {
            left = Easy.TreeNode(2).apply {
                right = Easy.TreeNode(4)
            }
            right = Easy.TreeNode(3)
        }

        val res2 = easy.t606(root2)

        assertEquals(res2, "1(2()(4))(3)")
    }

    @Test
    fun t976() {
        val res1 = easy.t976(intArrayOf(2, 1, 2))

        assertEquals(res1, 5)

        val res2 = easy.t976(intArrayOf(1, 2, 1))

        assertEquals(res2, 0)
    }

    @Test
    fun t1832() {
        val res1 = easy.t1832("thequickbrownfoxjumpsoverthelazydog")

        assertEquals(res1, true)

        val res2 = easy.t1832("leetcode")

        assertEquals(res2, false)
    }

    @Test
    fun t1480() {
        val res1 = easy.t1480(intArrayOf(1, 2, 3, 4))
        assertContentEquals(res1, intArrayOf(1, 3, 6, 10))

        val res2 = easy.t1480(intArrayOf(1, 1, 1, 1, 1))
        assertContentEquals(res2, intArrayOf(1, 2, 3, 4, 5))
    }

    @Test
    fun t1672() {
        val res1 = easy.t1672(arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1)))
        assertEquals(res1, 6)

        val res2 = easy.t1672(arrayOf(intArrayOf(1, 5), intArrayOf(7, 3),  intArrayOf(3, 5)))
        assertEquals(res2, 10)
    }
}