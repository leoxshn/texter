package posidon.mangoTK.ui

import gtk3.GtkContainer
import gtk3.gtk_container_add
import kotlinx.cinterop.CPointer

actual abstract class Container {
    abstract val container: CPointer<GtkContainer>
    actual open fun add(view: View) = gtk_container_add(container, view.gtkWidget)
}