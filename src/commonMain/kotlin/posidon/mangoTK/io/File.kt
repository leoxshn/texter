package posidon.mangoTK.io

expect inline class File(val path: String) {
    fun readText(): String
    fun readBytes(): ByteArray
    fun forEachLine(block: (line: String) -> Unit)
}