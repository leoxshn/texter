package posidon.mangoTK.util

/**
 * Class for raster images
 */
expect class Bitmap {
    companion object {
        fun fromFile(path: String): Bitmap?
    }
}