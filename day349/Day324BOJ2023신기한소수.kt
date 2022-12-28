fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()
    val pre = intArrayOf(2, 3, 5, 7)
    val sb = StringBuilder()

    fun isPrime(n: Int): Boolean {
        for (i in 2..Math.sqrt(n.toDouble()).toInt())
            if (n % i == 0) return false
        return true;
    }

    fun dfs(p: Int, n: Int) {
        if (n == N) {
            if (isPrime(p)) sb.append("$p\n")
            return
        }
        for (i in 1..9) {
            val t = p * 10 + i
            if (isPrime(t)) dfs(t, n + 1)
        }
    }

    for (i in pre) dfs(i, 1)
    print(sb)
}