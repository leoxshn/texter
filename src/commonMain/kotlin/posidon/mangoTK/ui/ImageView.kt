package posidon.mangoTK.ui

import posidon.mangoTK.util.Bitmap

expect class ImageView: View {
    constructor()
    constructor(init: ImageView.() -> Unit)
    var bitmap: Bitmap
}