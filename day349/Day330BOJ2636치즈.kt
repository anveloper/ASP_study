import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun input(): Int {
        nextToken(); return nval.toInt()
    }

    val N = input()
    val M = input()
    var cnt = 0
    var ans = 0

    var map = Array(N) { IntArray(M) }
    var list = ArrayList<Array<Int>>()
    for (r in 0 until N) for (c in 0 until M) {
        map[r][c] = input()
        if (map[r][c] == 1) list.add(arrayOf(r, c))
    }

    val dr = intArrayOf(-1, 1, 0, 0)
    val dc = intArrayOf(0, 0, -1, 1)

    fun bfs(idx: Int, jdx: Int) {
        val q = ArrayDeque<Pair<Int, Int>>()
        map[idx][jdx] = -1
        q.add(idx to jdx)
        while (!q.isEmpty()) {
            val (r, c) = q.removeFirst()
            for (i in 0..3) {
                val nr = r + dr[i]
                val nc = c + dc[i]
                if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue
                if (map[nr][nc] == 0) {
                    map[nr][nc] = -1
                    q.add(nr to nc)
                }
            }
        }
    }

    bfs(0, 0)
    while (list.isNotEmpty()) {
        cnt++
        ans = list.size
        val rList = ArrayList<Array<Int>>()
        var idx = 0
        for (i in 0 until ans) {
            val (r, c) = list[idx++]
            for (j in 0 until 4) {
                if (map[r + dr[j]][c + dc[j]] == -1) {
                    list.removeAt(--idx)
                    rList.add(arrayOf(r, c))
                    break
                }
            }
        }
        for (i in rList) {
            val (r, c) = i
            map[r][c] = -1
            bfs(r, c)
        }
    }
    print("$cnt\n$ans")
}