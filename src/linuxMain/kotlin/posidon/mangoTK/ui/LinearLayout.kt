package posidon.mangoTK.ui

import gtk3.*
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.reinterpret

actual class LinearLayout actual constructor(orientation: Orientation, init: LinearLayout.() -> Unit) : Container(), View {

    override val gtkWidget: CPointer<GtkWidget> = gtk_box_new(when (orientation) {
        Orientation.HORIZONTAL -> GtkOrientation.GTK_ORIENTATION_HORIZONTAL
        Orientation.VERTICAL -> GtkOrientation.GTK_ORIENTATION_VERTICAL
    }, 0)!!

    override val container: CPointer<GtkContainer> = gtkWidget.reinterpret()

    init { init() }
}