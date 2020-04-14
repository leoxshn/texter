package posidon.mangoTK.ui

import posidon.mangoTK.util.Bitmap

/**
 * This can only contain one view
 */
expect class Window(init: Window.() -> Unit) : Container {

    fun close()

    var title: String

    /**
     * Sets the window headerbar (only works on Gtk3+)
     * If the user is not on Linux, the method won't do anything.
     * In fact, it will be omitted at compilation for non-linux targets
     */
    fun ifLinuxHeaderBar(headerBar: GtkHeaderBar)
    fun ifLinuxHeaderBar(init: GtkHeaderBar.() -> Unit)

    var icon: Bitmap
}

