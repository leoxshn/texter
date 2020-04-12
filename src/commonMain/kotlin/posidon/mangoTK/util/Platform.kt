package posidon.mangoTK.util

expect object Platform {
    inline fun ifLinux(block: () -> Unit)
}