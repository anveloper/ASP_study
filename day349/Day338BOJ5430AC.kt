fun main() = with (System.`in`.bufferedReader()){
    val T = readLine().toInt();
    var reverse : Boolean; var error : Boolean
    var p : String; var n : Int; var arr : String
    var sl : List<String>; var fp : Int; var bp : Int
    val sb = StringBuilder()

    repeat(T) {
        p = readLine().toString()
        n = readLine().toInt()
        arr = readLine().toString()
        reverse = true; error = false
        fp = 0; bp = n - 1

        sl = arr.substring(1, arr.length - 1).split(',')

        for (j in p) {
            if (j == 'R') { reverse = !reverse }
            else {
                if (fp > bp) {
                    error = true
                    break
                }
                if (reverse) fp++
                else bp--
            }
        }

        if (error) {
            sb.append("error\n")
        } else {
            sb.append("[")
            if (reverse)
                for (q in fp..bp) {
                    sb.append(sl[q])
                    if (q != bp) sb.append(",")
                }
            else
                for (q in bp downTo fp) {
                    sb.append(sl[q])
                    if (q != fp) sb.append(",")
                }
            sb.append("]\n")
        }
    }
    print(sb)
}
