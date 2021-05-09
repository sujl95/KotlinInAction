package chapter3

class FuncDefinitionAndCall {
}

fun collectionMake() {
    val set = hashSetOf(1, 7, 13)
    val list = arrayListOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three") // to 키워드가 아닌 특별 함수다
    println(set)
    println(list)
    println(map)
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())
    val numbers = setOf(1, 14, 2)
    println(numbers.max())
    println(numbers.maxOrNull())
}

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) : String {
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}


fun main() {
//    collectionMake()
    val list = arrayListOf(1, 2, 3)
    println(joinToString(list, postfix = ";", prefix = "# "))
}