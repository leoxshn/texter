package posidon.mangoTK.util

inline fun Boolean.toInt() = if (this) 1 else 0
inline fun Int.toBool() = this != 0
inline fun UInt.toBool() = this != 0u