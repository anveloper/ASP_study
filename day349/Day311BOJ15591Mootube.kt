import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var N = 0
var Q = 0
var edges = arrayOf<ArrayList<Pair<Int, Int>>>()

var ans = 0
var k = 0
var visited = booleanArrayOf()

fun dfs(x: Int, usado: Int){
    if(usado < k)
        return
    visited[x] = true
    ans++
    edges[x].forEach{
        val next = it.first
        val edge = it.second
        if(!visited[next]){
            dfs(next, min(usado, edge))
        } 
    }
}

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
        k = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        ans = 0
        visited.fill(false)
        dfs(v, Integer.MAX_VALUE)
        sb.append(ans - 1)
        sb.append("\n")

    }
    print(sb.toString())
}

