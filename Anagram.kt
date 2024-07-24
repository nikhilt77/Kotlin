import java.util.Scanner

fun isAnagram(s1: String, s2: String): Boolean {
    val freq1 = IntArray(256)
    val freq2 = IntArray(256)
    if (s1.length != s2.length)
        return false

    for (i in s1.indices) {
        val c1 = s1[i]
        freq1[c1.toInt()]++
        val c2 = s2[i]
        freq2[c2.toInt()]++
    }

    for (i in 0..255) {
        if (freq1[i] != freq2[i]) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("Enter string 1:")
    val s1 = scanner.nextLine()
    println("Enter string 2:")
    val s2 = scanner.nextLine()
    if (isAnagram(s1, s2)) {
        println("Anagram")
    } else {
        println("Not anagram")
    }
}
