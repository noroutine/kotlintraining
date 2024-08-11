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
    fun move() {
        x++; y++
    }

    override fun toString(): String = "($x, $y)"
}

// shared state
val safeDot = Point(0, 0)
val unsafeDot = Point(0, 0)

class Cat(val name: String) {
    inner class Bow(val color: String) {
        fun printColor() {
            println("The cat named $name has a $color bow.")
        }
    }
}

class ChristmasTree(var color: String) {

    fun putTreeTopper(color: String) {
        TreeTopper(color).sparkle()
    }

    inner class TreeTopper(var color: String) {

        fun sparkle() {
            println("The sparkling ${color} tree topper looks stunning on the ${this@ChristmasTree.color} Christmas tree!")
        }
    }
}

class Pumpkin(val type: String, val isForHalloween: Boolean) {

    fun addCandle() {
        if (isForHalloween) {
            Candle().burning()
        } else {
            println("We don't need a candle.")
        }
    }

    inner class Candle {
        fun burning() {
            println("The candle is burning inside this spooky $type pumpkin! Boooooo!")
        }
    }
}


class Hero {
    val baseStrength = 1000

    class Equipment {
        val weapon = "trident"
        val weaponStrength = 300
    }
}

class Villain {
    val baseStrength = 500

    class Equipment {
        val weapon = "bomb"
        val weaponStrength = 700
    }
}

class Vehicle(val name: String) {
    inner class Engine(val horsePower: Int) {
        fun start() {
            println("RRRrrrrrrr....")
        }

        fun printHorsePower() {
            println("The $name vehicle has $horsePower horsepower.")
        }
    }
}

class Intern(val weeklyWorkload: Int) {
    val baseWorkload = 20

    class Salary {
        val basePay = 50
        val extraHoursPay = 2.8
    }

    val weeklySalary = Salary().basePay + (weeklyWorkload - baseWorkload) * Salary().extraHoursPay
}

data class TextField(
    var text: String = "Hello!", var textSize: Int = 12, var fontFamily: String = "Roboto"
)

data class Movie(
    var name: String = "The Knack ...and How to Get It",
    var link: String = "https://",
    var dataBaseName: String = "IMDB"
)

data class Musician(var name: String = "", var band: String = "", var role: String = "")

fun filterAndMatch(): Map<String, Int> =
    readln().lowercase().split(' ').map { it to it.length }.also { println(it.size) }.toMap()

data class Microphone(
    var track: String = "", var frequency: Int = 0, var effect: String = "", var sensitivity: Double = 0.0
)

//fun main() = IntArray(readln().toInt()) { readln().toInt() }.map { it.toDouble() * readln().toInt() / 100 }
//    .withIndex()
//    .maxBy { (_, t) -> t }
//    .let { it.index + 1 }
//    .run(::println)

/* Do not change code below */
//fun main() =
//    "([aeiouy]+|[bcdfghjklmnpqrstvwxz]+)".toRegex().findAll(readln().lowercase())
//        .map { (it.value.length - 1) / 2 }.sum().run(::println)
//

//fun main() = readln().map { it.digitToInt() }.let {
//    println(if (it[0] + it[1] + it[2] == it[3] + it[4] + it[5]) "Lucky" else "Regular")
//}


//fun main() = readln().split(" ").map { it.toInt() }.let { reqs ->
//    val charTable = arrayOf('A'..'Z', 'a'..'z', '0'..'9')
//
//    val charType = listOf(
//        List(reqs[0]) { 0 },
//        List(reqs[1]) { 1 },
//        List(reqs[2]) { 2 },
//        List(reqs[3] - reqs[0] - reqs[1] - reqs[2]) { (0..2).random() }
//    ).flatten().shuffled()
//
//    val pwd = CharArray(charType.size)
//    pwd[0] = charTable[charType[0]].random()
//
//    for (i in 1 until pwd.size) {
//        do {
//            pwd[i] = charTable[charType[i]].random()
//        } while (pwd[i] == pwd[i - 1])
//    }
//    pwd.joinToString("")
//}.run(::println)

//fun main() = readln().split(" ").map { it.toDouble() }
//    .run { println("${firstOrNull { it >= 5.0 }}:${max()}") }

//fun main() = readln().split(" ").map { it.split("-") }
//        .findLast { it[1].toInt() > 200 }
//        .let { it?.get(0) ?: "No ship found" }
//        .run(::println)
//

//fun main() = readln().split(" ").map { it.reversed() }.find { it[0] == 'm' }.run(::println)

//fun main() {
//    val listOfNames = listOf("Pablo", "John", "Jane", "Mary", "Peter")
//    println(
//        listOfNames.firstNotNullOf { item -> item.length.takeIf { it >= 5 } }
//    )
//}

fun main() = readln().split(" ").find { it.first() == 'j' && it.last() == 'e' }.run(::println)
