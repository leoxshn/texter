package posidon.mangoTK.ui

import gtk3.GtkWidget
import kotlinx.cinterop.CPointer

actual interface View {
    val gtkWidget: CPointer<GtkWidget>
}