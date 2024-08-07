import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class UserTest {
    lateinit var names: Array<String?>
    lateinit var passwords: Array<String?>
    lateinit var expectedOutcomes: BooleanArray

    var index = 0

    var user: User? = null
    var expected = false

    @BeforeAll
    fun setUp() {
        names = arrayOf("Alice", "Alice", "Alice", "", null, "    ")
        passwords = arrayOf("12345678", "123", null, "12345678", "12345678", "12345678")
        expectedOutcomes = booleanArrayOf(true, false, false, false, false, false)
    }

    @BeforeEach
    fun createUser() {
        user = User(names[index], passwords[index])
        expected = expectedOutcomes[index]
    }

    @AfterEach
    fun incrementIndex() {
        index++
    }

    @RepeatedTest(value = 6, name = "user.isValid() test {currentRepetition}/{totalRepetitions}")
    fun isValid() {
        assertEquals(expected, user!!.isValid)
    }
}