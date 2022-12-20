import kotlin.math.min

private var arr = listOf<Int>()
private val ans = mutableSetOf<MutableList<Int>>()

private fun main() {
    arr = readLine()!!.split(' ').map(String::toInt)
    dfs(-1, -2, mutableListOf(0, 0, arr[2]))
    ans.filter { it.first() == 0 }.map(List<Int>::last).distinct().sorted()
        .forEach { print("$it ") }
}

fun dfs(idx: Int, jdx: Int, waters: MutableList<Int>) {
    if (!ans.add(waters)) return

    for ((i, source) in waters.withIndex()) {
        if (source <= 0) continue
        for ((j, target) in waters.withIndex()) {
            if (i == j || (i == jdx && j == idx)) continue
            val w = min(source, arr[j] - target)
            dfs(
                i,
                j,
                waters.toMutableList().apply { this[i] -= w; this[j] += w })
        }
    }
}