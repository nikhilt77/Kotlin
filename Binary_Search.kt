import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter Array size:")
    val n = scanner.nextInt()
    var l = 0
    var h = n - 1
    var mid: Int
    var flag = -1
    val A = IntArray(n)

    println("Enter Search key:")
    val s = scanner.nextInt()
    println("Enter Sorted Array:")
    for (i in 0 until n) {
        A[i] = scanner.nextInt()
    }

    while (l <= h) {
        mid = (l + h) / 2
        if (A[mid] == s) {
            flag = mid
            break
        } else if (A[mid] < s) {
            l = mid + 1
        } else {
            h = mid - 1
        }
    }

    if (flag != -1) {
        println("Element found at: $flag")
    } else {
        println("Element not found")
    }
}
