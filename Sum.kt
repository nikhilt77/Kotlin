fun List<Int>.sum(initial: Int = 0): Int {
    return this.fold(initial) { acc, i -> acc + i }
}

fun main(args: Array<String>) {
    val scanner = java.util.Scanner(System.`in`)

    print("Enter the number of elements: ")
    val n = scanner.nextInt()

    print("Enter the initial sum (or press enter to skip): ")
    val initialSumInput = readLine()
    val initialSum = if (initialSumInput.isNullOrBlank()) 0 else initialSumInput.toInt()

    val list = mutableListOf<Int>()
    for (i in 1..n) {
        print("Enter element $i: ")
        val element = scanner.nextInt()
        list.add(element)
    }

    val sum = list.sum(initialSum)
    println("The sum is: $sum")
}
