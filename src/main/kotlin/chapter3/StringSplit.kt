package chapter3

class StringSplit {
}

//fun parsePath(path: String) {
//    val directory = path.substringBeforeLast("/")
//    val fullName = path.substringAfterLast("/")
//    val fileName = fullName.substringBeforeLast(".")
//    val extension = fullName.substringAfterLast(".")
//    println("Dir: $directory, name: $fileName, ext: $extension")
//}

fun parsePath(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}

fun main() {
    val path = "/Users/thewing/kotlinInAction/chapter3.adoc.doc"
    parsePath(path)
}