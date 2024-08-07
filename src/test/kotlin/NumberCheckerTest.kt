import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberCheckerTest {
    @Test
    fun `Test checkNumber function with even number`() {
        val numberChecker = NumberChecker()
        val userInput = mockk<Int>()
        every { userInput } returns 2
        assertEquals(userInput, 2)

        val result = numberChecker.checkNumber(userInput)

        assertEquals("even", result)
    }

    @Test
    fun `Test checkNumber function with odd number`() {
        val numberChecker = NumberChecker()
        val userInput = mockk<Int>()
        every { userInput } returns 3

        val result = numberChecker.checkNumber(userInput)

        assertEquals("odd", result)
    }

    @Test
    fun `Test checkNumber function with zero`() {
        val numberChecker = NumberChecker()
        val userInput = mockk<Int>()
        every { userInput } returns 0

        val result = numberChecker.checkNumber(userInput)

        assertEquals("even", result)
    }

    @Test
    fun `Test checkNumber function with negative even number`() {
        val numberChecker = NumberChecker()
        val userInput = mockk<Int>()
        every { userInput } returns -2

        val result = numberChecker.checkNumber(userInput)

        assertEquals("even", result)
    }

    @Test
    fun `Test checkNumber function with negative odd number`() {
        val numberChecker = NumberChecker()
        val userInput = mockk<Int>()
        every { userInput } returns -3

        val result = numberChecker.checkNumber(userInput)

        assertEquals("odd", result)
    }
}