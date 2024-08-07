import org.junit.jupiter.api.*

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LifeCycleTest {
    constructor(){
        println("Test Class Constructor")
    }

    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            println("Before all tests")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            println("After all tests")
        }
    }

    @BeforeEach
    fun beforeEach() {
        println("Before each test")
    }

    @AfterEach
    fun afterEach() {
        println("After each test")
    }

    @Test
    fun test1() {
        println("Test 1")
    }

    @Test
    fun test2() {
        println("Test 2")
    }
}