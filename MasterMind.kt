package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0
    
    val secretCharCount = mutableMapOf<Char, Int>()
    val guessCharCount = mutableMapOf<Char, Int>()

    for (i in secret.indices) {
        if (secret[i] == guess[i]) {
            rightPosition++
        } else {
            secretCharCount[secret[i]] = secretCharCount.getOrDefault(secret[i], 0) + 1
            guessCharCount[guess[i]] = guessCharCount.getOrDefault(guess[i], 0) + 1
        }
    }

    for ((char, count) in guessCharCount) {
        if (char in secretCharCount) {
            wrongPosition += minOf(count, secretCharCount[char]!!)
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}

fun main() {
    val secret = "ABCD"
    val guess = "AECB"
    val evaluation = evaluateGuess(secret, guess)
    println("Right Position: ${evaluation.rightPosition}")
    println("Wrong Position: ${evaluation.wrongPosition}")
}
