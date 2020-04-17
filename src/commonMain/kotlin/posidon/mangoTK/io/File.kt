package posidon.mangoTK.io

expect inline class File(val path: String) {
    fun readText(): String
    fun readBytes(): ByteArray
    fun forEachLine(block: (line: String) -> Unit)
}

inline val File.name get() = path.substring(path.lastIndexOf('/') + 1)
inline val File.noExtName: String get() {
    val lastDotI = path.lastIndexOf('.')
    return if (lastDotI == -1) name else path.substring(path.lastIndexOf('/') + 1, lastDotI)
}