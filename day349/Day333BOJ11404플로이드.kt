import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun input(): Int {
        nextToken(); return nval.toInt()
    }

    val INF = Long.MAX_VALUE

    val N = input()
    val M = input()
    val dp = Array(N + 1) { i ->
        LongArray(N + 1) { j ->
            if (i == j) 0 else INF
        }
    }

    repeat(M) {
        val s = input()
        val e = input()
        val c = input().toLong()
        if (dp[s][e] > c) dp[s][e] = c
    }

    var check = false
    while (true) {
        if (check) break
        check = true
        for (i in 1..N) for (j in 1..N) for (k in 1..N) {
            if (dp[i][k] != INF && dp[k][j] != INF) if (dp[i][j] > dp[i][k] + dp[k][j]) {
                dp[i][j] = dp[i][k] + dp[k][j]
                check = false
            }
        }
    }
    val sb = StringBuilder()
    for (i in 1..N) {
        for (j in 1 until N) {
            sb.append(if (dp[i][j] == INF) 0 else dp[i][j]).append(" ")
        }
        sb.append(if (dp[i][N] == INF) 0 else dp[i][N]).append("\n")
    }
    print(sb)
}
