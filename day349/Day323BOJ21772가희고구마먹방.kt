import java.util.*

fun main() = StringTokenizer(System.`in`.bufferedReader().readText()).run {
    val R = nextToken().toInt();
    val C = nextToken().toInt();
    val T = nextToken().toInt();
    var ans = 0
    var map = Array(R) { nextToken().toCharArray() };
    var idx = 0;
    var jdx = 0;
    for (i in 0 until R) for (j in 0 until C) if (map[i][j] == 'G') {
        idx = i;
        jdx = j;
    }
    val dr = intArrayOf(-1, 1, 0, 0)
    val dc = intArrayOf(0, 0, -1, 1)
    fun dfs(t: Int, idx: Int, jdx: Int, sum: Int) {
        if (t == T) {
            if (ans < sum) ans = sum;
            return;
        }
        repeat(4) {
            val nr = idx + dr[it]
            val nc = jdx + dc[it]
            if (nr in 0 until R && nc in 0 until C && map[nr][nc] != '#') {
                val tmp = map[nr][nc]
                map[nr][nc] = '.'
                dfs(t + 1, nr, nc, if (tmp == 'S') sum + 1 else sum)
                map[nr][nc] = tmp
            }
        }
    }
    dfs(0, idx, jdx, 0)
    println(ans)
}
