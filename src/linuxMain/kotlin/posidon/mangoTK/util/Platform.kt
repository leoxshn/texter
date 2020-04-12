package posidon.mangoTK.util

actual object Platform {
    actual val name = "Linux"
    actual val guiName = "Gtk"
    actual inline fun ifLinux(block: () -> Unit) = block()
    actual inline fun ifNotLinux(block: () -> Unit) {}
}