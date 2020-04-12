package posidon.mangoTK.ui

expect class Window(init: Window.() -> Unit) : Container {

    fun close()

    var title: String
}