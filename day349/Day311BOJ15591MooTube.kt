import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

private var N = 0
private var Q = 0
private var edges = arrayOf<ArrayList<Pair<Int, Int>>>()

private var ans = 0
private var K = 0
private var visited = booleanArrayOf()

// Day311BOJ15591MooTube
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    N = st.nextToken().toInt()
    Q = st.nextToken().toInt()
    edges = Array(N + 1){ArrayList<Pair<Int, Int>>()}
    visited = BooleanArray(N + 1){false}
    repeat(N - 1){
        st = StringTokenizer(readLine())
        var p = st.nextToken().toInt()
        var q = st.nextToken().toInt()
        var r = st.nextToken().toInt()
        edges[p].add(Pair(q, r))
        edges[q].add(Pair(p, r))
    }

    var sb = StringBuilder()
    repeat(Q){
        st = StringTokenizer(readLine())
        K = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        ans = 0
        visited.fill(false)
        dfs(v, Integer.MAX_VALUE)
        sb.append(ans - 1)
        sb.append("\n")

    }
    print(sb.toString())
}

fun dfs(v: Int, k: Int){
    if(k < K)
        return
    visited[v] = true
    ans++
    edges[v].forEach{
        val n = it.first
        val c = it.second
        if(!visited[n]){
            dfs(n, min(k, c))
        }
    }
}


