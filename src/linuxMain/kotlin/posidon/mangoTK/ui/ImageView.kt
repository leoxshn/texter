package posidon.mangoTK.ui

import gtk3.GtkWidget
import gtk3.gtk_image_get_pixbuf
import gtk3.gtk_image_new
import gtk3.gtk_image_set_from_pixbuf
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret
import posidon.mangoTK.util.Bitmap

actual class ImageView: View {

    override val gtkWidget: CPointer<GtkWidget> = gtk_image_new()!!.reinterpret()

    actual constructor()
    actual constructor(init: ImageView.() -> Unit) { init() }

    actual var bitmap: Bitmap
        get() = Bitmap(gtk_image_get_pixbuf(gtkWidget.reinterpret()))
        set(value) = gtk_image_set_from_pixbuf(gtkWidget.reinterpret(), value.pixbuf)
}