package posidon.mangoTK.ui

expect class Window(init: Window.() -> Unit) : Container {

    fun close()

    var title: String

    fun ifLinuxSetHeaderBar(headerBar: GtkHeaderBar)
    fun ifLinuxSetHeaderBar(init: GtkHeaderBar.() -> Unit)
}

