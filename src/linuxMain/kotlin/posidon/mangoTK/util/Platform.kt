package posidon.mangoTK.util

actual object Platform {
    actual inline fun ifLinux(block: () -> Unit) = block()
}