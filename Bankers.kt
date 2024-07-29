import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Enter the number of processes: ")
    val n = scanner.nextInt()

    println("Enter the number of resources: ")
    val m = scanner.nextInt()

    val alloc = Array(n) { IntArray(m) }
    val max = Array(n) { IntArray(m) }
    val avail = IntArray(m)
    val f = IntArray(n)
    val ans = IntArray(n)
    var ind = 0

    println("Enter the allocation matrix: ")
    for (i in 0 until n) {
        for (j in 0 until m) {
            alloc[i][j] = scanner.nextInt()
        }
    }

    println("Enter the max matrix: ")
    for (i in 0 until n) {
        for (j in 0 until m) {
            max[i][j] = scanner.nextInt()
        }
    }

    println("Enter the available resources: ")
    for (i in 0 until m) {
        avail[i] = scanner.nextInt()
    }

    for (k in 0 until n) {
        f[k] = 0
    }

    val need = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            need[i][j] = max[i][j] - alloc[i][j]
        }
    }

    var y = 0
    for (k in 0 until 5) {
        for (i in 0 until n) {
            if (f[i] == 0) {
                var flag = 0
                for (j in 0 until m) {
                    if (need[i][j] > avail[j]) {
                        flag = 1
                        break
                    }
                }

                if (flag == 0) {
                    ans[ind++] = i
                    for (y in 0 until m) {
                        avail[y] += alloc[i][y]
                    }
                    f[i] = 1
                }
            }
        }
    }

    println("Following is the SAFE Sequence")
    for (i in 0 until n - 1) {
        print(" P${ans[i]} ->")
    }
    println(" P${ans[n - 1]}")
}
