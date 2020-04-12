package posidon.mangoTK.util

expect object Platform {
    val name: String
    val guiName: String
    inline fun ifLinux(block: () -> Unit)
    inline fun ifNotLinux(block: () -> Unit)
}