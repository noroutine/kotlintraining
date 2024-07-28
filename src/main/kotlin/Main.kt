/**
 * We want our dots to walk a narrow safe line and reach home!
 */
import java.util.concurrent.Semaphore

// Let's create a single mutex
object GlobalMutex {
    private val semaphore = Semaphore(1)
    val lock: () -> Unit = semaphore::acquire
    val unlock: () -> Unit = semaphore::release
}

class Point(var x: Long = 0, var y: Long = 0) {
    fun move() { x++; y++ }
    override fun toString(): String = "($x, $y)"
}

// shared state
val safeDot = Point(0, 0)
val unsafeDot = Point(0, 0)

fun main() {
    repeat(10_000) {
        // massive run with safe shared access
        Thread {
            // this is how synchronized works
            // synchronized(safeDot) {
            GlobalMutex.lock()
            repeat(1000_000) {
                safeDot.move()
            }
            GlobalMutex.unlock()
            // }
        }.start()

        // massive run with unsafe shared access
        Thread {
            repeat(1000_000) {
                unsafeDot.move()
            }
        }.start()
    }

    println("Safe dot arrived home at   $safeDot")
    println("Unsafe dot is lost at      $unsafeDot")
}