package chapter2

import chapter2.Color.*
import java.io.BufferedReader
import java.io.StringReader
import java.util.*

class WhenColor {
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun getWarmth(color: Color) =
    when (color) {
        RED, ORANGE, YELLOW -> "warm"
        GREEN -> "neutral"
        BLUE, INDIGO, VIOLET -> "cold"
    }

fun mix(c1: Color, c2:Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
        (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
        else -> throw Exception("Dirty color")
    }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr) : Int =
    when (e) {
        is Num -> {
            e.value
        }
        is Sum -> {
            eval(e.right) + eval(e.left)
        }
        else -> {
            throw IllegalArgumentException("Unknown expression")
        }
    }

fun evalWithLogging(e: Expr) : Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")

    }

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null  // <--예외가 발생하면 null 을 사용한다
    }
    println(number)
}

fun main() {
//    val binaryReps = TreeMap<Char, String>()

//    for (c in 'A'..'F') {
//        val binary = Integer.toBinaryString(c.toInt())
//        binaryReps[c] = binary
//    }
//
//    for ((letter, binary) in binaryReps) {
//        println("$letter = $binary")
//    }



//    val list = arrayListOf("10", "11", "1010")
//    for ((index, element) in list.withIndex()) {
//        println("$index : $element")
//    }

//    println(isLetter('q'))
//    println(isNotDigit('x'))

//    println(recognize('8'))

//    println("Kotlin" in "Java".."Scala")

//    println("Kotlin" in setOf("Java", "Scala"))

//    val reader = BufferedReader(StringReader("239"))
//    println(readNumber(reader))

//    val reader = BufferedReader(StringReader("not a number"))
//    readNumber(reader)
}