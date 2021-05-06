package chapter2

class MaxKotlin {
}

fun main(args:Array<String>) {
    val maxValue = max(1, 2)
    println("maxValue : $maxValue")
}

fun max(a: Int, b: Int): Int = if (a > b) a else b