fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val K = readLine().toInt()

    var l = 0
    var r = K

    while (l <= r) {
        val m = (l + r) / 2
        var cnt = 0

        for (i in 1..N) {
            cnt += (m / i).coerceAtMost(N)
        }

        if (cnt < K) {
            l = m + 1
        } else {
            r = m - 1
        }
    }

    println(l)
}