import kotlin.math.max

fun displayMax(a: Int, b: Int) {
    println(max(a, b))
}

fun main() {
    println("Enter two numbers:")
    val a = readLine()?.toIntOrNull()
    val b = readLine()?.toIntOrNull()

    if (a != null && b != null) {
        displayMax(a, b)
    } else {
        println("Invalid input. Please enter valid integers.")
    }
}
