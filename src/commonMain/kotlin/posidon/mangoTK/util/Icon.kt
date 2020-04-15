package posidon.mangoTK.util

expect enum class Icon {
    inline FILE,
    inline FOLDER;
    fun get(size: IconSize): Bitmap
}

enum class IconSize(val resolution: Int) {
    inline VerySmall(16),
    inline Small(24),
    inline Medium(32),
    inline Big(48),
    inline VeryBig(64)
}