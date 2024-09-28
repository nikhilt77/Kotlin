fun isNiceString(s: String): Boolean {
    // Condition 1: Check if the string contains forbidden substrings
    val containsForbidden = s.contains("bu") || s.contains("ba") || s.contains("be")
    
    // Condition 2: Check if the string contains at least three vowels
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    val vowelCount = s.count { it in vowels }
    val hasAtLeastThreeVowels = vowelCount >= 3

    // Condition 3: Check if the string contains double letters
    val hasDoubleLetter = s.zipWithNext().any { it.first == it.second }

    // Count how many conditions are satisfied
    var satisfiedConditions = 0
    if (!containsForbidden) satisfiedConditions++
    if (hasAtLeastThreeVowels) satisfiedConditions++
    if (hasDoubleLetter) satisfiedConditions++

    // Return true if at least two conditions are satisfied
    return satisfiedConditions >= 2
}

fun main() {
    println("Enter a string:")
    val input = readLine() ?: ""
    
    if (isNiceString(input)) {
        println("The string '$input' is nice.")
    } else {
        println("The string '$input' is not nice.")
    }
}
