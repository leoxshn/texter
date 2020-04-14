package posidon.mangoTK.util

/**
 * This contains the info about the user's platform
 * This class also contains compile time platform checking functions (ifLinux {}, ifNotLinux {})
 */
expect object Platform {
    val name: String
    val guiName: String
    inline fun ifLinux(block: () -> Unit)
    inline fun ifNotLinux(block: () -> Unit)
}