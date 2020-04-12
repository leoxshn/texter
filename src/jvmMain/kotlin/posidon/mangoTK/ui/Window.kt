package posidon.mangoTK.ui

import java.awt.event.WindowEvent
import javax.swing.JFrame


actual class Window actual constructor(init: Window.() -> Unit) : Container() {

    override val jContainer = JFrame().apply {
        isResizable = true
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }

    init { init() }

    actual fun close() = jContainer.dispatchEvent(WindowEvent(jContainer, WindowEvent.WINDOW_CLOSING))

    actual var title: String
        get() = jContainer.title
        set(value) { jContainer.title = value }
}