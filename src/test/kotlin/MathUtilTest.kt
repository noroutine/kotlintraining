
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class MathUtilTest {
    private var result = 5
    private val mathUtil = MathUtil()

    @AfterEach
    fun afterEach(){
        result = 5
    }

    @Test
    fun test_Add() {
        result = mathUtil.add(result, 5)
        println("test_Add(5,5) => $result")
        assertEquals(10, result)
    }

    @Test
    fun test_Multiply() {
        result = mathUtil.multiply(result, 5)
        println("test_Multiply(5,5) => $result")
        assertEquals(25, result)
    }

    @Test
    fun test_Divide() {
        result = mathUtil.divide(result, 5)
        println("test_Divide(5,5) => $result")
        assertEquals(1, result)
    }
}