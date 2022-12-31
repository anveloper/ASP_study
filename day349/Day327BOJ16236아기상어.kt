import java.io.StreamTokenizer

fun main() = StreamTokenizer(System.`in`.bufferedReader()).run {
    fun input(): Int {
        nextToken(); return nval.toInt()
    }

    val n = input()
    val map = Array(n) { IntArray(n) }
    var cur = 0 to 0
    var size = 2
    var cnt = 0
    for (r in 0 until n) for (c in 0 until n) {
        val num = input()
        if (num == 9) cur = r to c
        else map[r][c] = num
    }

    val dr = intArrayOf(-1, 0, 0, 1)
    val dc = intArrayOf(0, -1, 1, 0)
    val q = ArrayDeque<Pair<Int, Int>>()

    fun eat() {
        while (q.isNotEmpty()) {
            val (r, c) = q.removeFirst()
            if (map[r][c] in 1 until size && (r < cur.first || (r == cur.first && c < cur.second))) {
                cur = r to c
            }
        }
        map[cur.first][cur.second] = 0
        cnt += 1
        if (cnt == size) {
            size += 1
            cnt = 0
        }
    }

    fun find(): Int {
        var ans = 0
        val visited = Array(n) { BooleanArray(n) }
        val nq = ArrayDeque<Pair<Int, Int>>()
        while (q.isNotEmpty()) {
            repeat(q.size) {
                val (r, c) = q.removeFirst()
                if (map[r][c] in 1 until size) {
                    cur = r to c
                    eat()
                    return ans
                }
                for (dir in 0..3) {
                    val nr = r + dr[dir]
                    val nc = c + dc[dir]
                    if (nr in 0 until n && nc in 0 until n
                        && map[nr][nc] <= size && !visited[nr][nc]
                    ) {
                        nq.add(nr to nc)
                        visited[nr][nc] = true
                    }
                }
            }
            ans += 1
            q.addAll(nq)
            nq.clear()
        }
        return 0
    }


    var ans = 0
    do {
        q.add(cur)
        val res = find()
        ans += res
    } while (res != 0)
    print(ans)
}
