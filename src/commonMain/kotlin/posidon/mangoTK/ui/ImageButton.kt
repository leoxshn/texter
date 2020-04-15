package posidon.mangoTK.ui

import posidon.mangoTK.util.Bitmap

expect class ImageButton(init: ImageButton.() -> Unit) : View {
    fun onClick(action: ImageButton.() -> Unit)
    var bitmap: Bitmap
}