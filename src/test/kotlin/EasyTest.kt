import org.junit.jupiter.api.Test
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
}