package posidon.mangoTK.util

actual object Platform {
    actual val name = "Java"
    actual val guiName = "AWT"
    actual inline fun ifLinux(block: () -> Unit) {}
    actual inline fun ifNotLinux(block: () -> Unit) = block()
}